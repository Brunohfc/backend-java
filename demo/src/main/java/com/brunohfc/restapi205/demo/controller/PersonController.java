package com.brunohfc.restapi205.demo.controller;

import com.brunohfc.restapi205.demo.data.dto.v1.PersonDTO;
import com.brunohfc.restapi205.demo.data.dto.v2.PersonDTOV2;
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
    public List<PersonDTO> listPerson(){
        return personService.findAll();
    }

    @PostMapping("/create")
    public PersonDTO create(@RequestBody PersonDTO person){
        return personService.create(person);


    }

    @PostMapping(value = "/v2/create")
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return personService.createv2(person);

    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable Long id){
        return personService.getById(id);
    }


    @PutMapping("/{id}")
    public PersonDTO update(@RequestBody PersonDTO person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
