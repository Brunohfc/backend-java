package com.brunohfc.restapi205.demo.controller;

import com.brunohfc.restapi205.demo.data.dto.v1.PersonDTO;
import com.brunohfc.restapi205.demo.data.dto.v2.PersonDTOV2;
import com.brunohfc.restapi205.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PersonDTO> listPerson(){
        return personService.findAll();
    }

    @PostMapping(value = "/create",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonDTO create(@RequestBody PersonDTO person){
        return personService.create(person);


    }

    @PostMapping(value = "/v2/create",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return personService.createv2(person);

    }

    @GetMapping(value = "/{id}" ,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonDTO getPerson(@PathVariable Long id){
        return personService.getById(id);
    }


    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonDTO update(@RequestBody PersonDTO person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
