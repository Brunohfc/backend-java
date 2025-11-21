package com.brunohfc.restapi205.demo.services;

import com.brunohfc.restapi205.demo.config.EmailConfig;
import com.brunohfc.restapi205.demo.data.dto.request.EmailRequestDTO;
import com.brunohfc.restapi205.demo.mail.EmailSender;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
