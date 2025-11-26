package com.brunohfc.restapi205.demo.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.brunohfc.restapi205.demo.data.dto.security.TokenDTO;
import com.brunohfc.restapi205.demo.exception.InvalidJWTAuthException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey;
    @Value("${security.jwt.token.expire-length:3600000}")
    private Long millisecondsValid;

    @Autowired
    private UserDetailsService userDetailsService;

    Algorithm algorithm = null;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());
    }

    public TokenDTO createAccessToken(String userName, List<String> roles){

        Date created = new Date();
        Date expiration = new Date(created.getTime() + millisecondsValid);
        String accessToken = getAccessToken(userName, roles, created, expiration);
        String refreshToken = getRefreshToken(userName, roles, created);
        return new TokenDTO(userName, true, created, expiration, accessToken, refreshToken);
    }

    private String getAccessToken(String userName, List<String> roles, Date now, Date validity) {
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withSubject(userName)
                .withIssuer(url)
                .sign(algorithm);
    }

    private String getRefreshToken(String userName, List<String> roles, Date now) {
        Date refreshtokenvalidate = new Date(now.getTime() + (millisecondsValid * 3) ); //valido por 3h
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(now)
                .withExpiresAt(refreshtokenvalidate)
                .withSubject(userName)
                .sign(algorithm);
    }

    public Authentication getAuth(String token){
        DecodedJWT decodedJWT = decoded(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private DecodedJWT decoded(String token) {
        Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
        JWTVerifier verifier = JWT.require(alg).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return  decodedJWT;

    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring("Bearer ".length());
        }
        else {
            throw new InvalidJWTAuthException("Invalid JWT Token");
        }
    }

    public boolean validateToken(String token){
        DecodedJWT decodedJWT = decoded(token);
        try {
            if(decodedJWT.getExpiresAt().before(new Date())){
                return false;
            }
            return  true;
        } catch (Exception e) {
            throw new InvalidJWTAuthException("Expired or invalid JWT Token");
        }
    }
}
