package com.brunohfc.restapi205.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {

    private String hots;
    private int port;
    private  String username;
    private String password;
    private String from;
    private boolean ssl;
    public EmailConfig() {
    }

    public EmailConfig(String hots, int port, String username, String password, String from, boolean ssl) {
        this.hots = hots;
        this.port = port;
        this.username = username;
        this.password = password;
        this.from = from;
        this.ssl = ssl;
    }

    public String getHots() {
        return hots;
    }

    public void setHots(String hots) {
        this.hots = hots;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailConfig that)) return false;
        return getPort() == that.getPort() && isSsl() == that.isSsl() && Objects.equals(getHots(), that.getHots()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getFrom(), that.getFrom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHots(), getPort(), getUsername(), getPassword(), getFrom(), isSsl());
    }
}
