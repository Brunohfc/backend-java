package com.brunohfc.restapi205.demo.controller;

import com.brunohfc.restapi205.demo.controller.docs.EmailControllerDocs;
import com.brunohfc.restapi205.demo.data.dto.request.EmailRequestDTO;
import com.brunohfc.restapi205.demo.services.EmailService;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/email/v1")

public class EmailController implements EmailControllerDocs {

    @Autowired
    EmailService emailService;

    @Override
    @PostMapping
    public ResponseEntity<String> sendEamil(@RequestBody EmailRequestDTO dto) throws AddressException {
        emailService.sendEmail(dto);
        return new ResponseEntity<>("email send with success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> sendEamilWithAttachment(@RequestBody String emailRequestJson, MultipartFile file) {

        return null;
    }
}
