package com.brunohfc.restapi205.demo.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/math")
public class Math {

    @GetMapping("/somar/{num1}/{num2}")
    public int somar(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return num1 + num2;
    }

    @GetMapping("/subtracao/{num1}/{num2}")
    public int subtracao(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return num1 - num2;
    }

    @GetMapping("/multiplicacao/{num1}/{num2}")
    public int multiplicacao(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return java.lang.Math.multiplyExact(num1, num2);
    }

    @GetMapping("/divisao/{num1}/{num2}")
    public int divisao(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        if(num2 == 0){
            throw new UnsupportedOperationException("Divisao nao suportada");
        }
        return java.lang.Math.divideExact(num1, num2);
    }

    @GetMapping("/media/{num1}/{num2}")
    public double media(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return (num1 + num2) / 2;
    }
    @GetMapping("/raizquadrada/{num1}")
    public double raiz(@PathVariable("num1") double num1){
        return java.lang.Math.sqrt(num1);
    }





}
