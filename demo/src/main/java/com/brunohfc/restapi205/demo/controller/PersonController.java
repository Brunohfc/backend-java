package com.brunohfc.restapi205.demo.controller;

import com.brunohfc.restapi205.demo.model.Person;
import com.brunohfc.restapi205.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;


    @GetMapping("/ola")
    public String ola(){
        return "Funcionando";
    }

    @GetMapping
    public List<Person> listPerson(){
        return personService.findAll();
    }

    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        personService.create(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getById(id);
    }


    @PutMapping("/{id}")
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
