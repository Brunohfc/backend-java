package com.brunohfc.restapi205.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class Math {

    @GetMapping("/somar/{num1}/{num2}")
    public int somar(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return num1 + num2;
    }

}
