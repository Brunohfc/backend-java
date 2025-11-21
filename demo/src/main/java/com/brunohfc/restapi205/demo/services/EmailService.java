package com.brunohfc.restapi205.demo.services;

import com.brunohfc.restapi205.demo.config.EmailConfig;
import com.brunohfc.restapi205.demo.data.dto.request.EmailRequestDTO;
import com.brunohfc.restapi205.demo.mail.EmailSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    EmailSender emailSender;
    @Autowired
    EmailConfig emailConfig;

    public void sendEmail(EmailRequestDTO dto) throws AddressException {
        emailSender.to(dto.getTo())
                .withSubject(dto.getSubject())
                .withMessage(dto.getBody())
                .sendEmail(emailConfig);
    }

    public void sendEmailWithAttach(String emailRequestJson, MultipartFile file){
        File tempFile = null;

        try {
            EmailRequestDTO request = new ObjectMapper().readValue(emailRequestJson, EmailRequestDTO.class);
            tempFile = File.createTempFile("file",file.getOriginalFilename());
            file.transferTo(tempFile);

            emailSender.to(request.getTo())
                    .withSubject(request.getSubject())
                    .withMessage(request.getBody())
                    .withAttachment(tempFile.getAbsolutePath())
                    .sendEmail(emailConfig);

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (AddressException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
