package com.brunohfc.restapi205.demo.controller;

import com.brunohfc.restapi205.demo.controller.docs.EmailControllerDocs;
import com.brunohfc.restapi205.demo.data.dto.request.EmailRequestDTO;
import com.brunohfc.restapi205.demo.services.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/email/v1")

public class EmailController implements EmailControllerDocs {

    @Autowired
    EmailService emailService;

    @PostMapping
    @Override
    public ResponseEntity<String> sendEamil(@RequestBody EmailRequestDTO dto) throws AddressException {
        emailService.sendEmail(dto);
        return new ResponseEntity<>("email send with success", HttpStatus.OK);
    }

    @PostMapping(value = "/attach", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<String> sendEamilWithAttachment(@RequestParam("emailRequest") String emailRequest,
                                                         @RequestParam("attach") MultipartFile file) {
        emailService.sendEmailWithAttach(emailRequest, file);
        return new ResponseEntity<>("email send with success", HttpStatus.OK);
    }
}
