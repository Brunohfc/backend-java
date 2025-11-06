package com.brunohfc.restapi205.demo.services;

import com.brunohfc.restapi205.demo.controller.PersonController;
import com.brunohfc.restapi205.demo.data.dto.v1.PersonDTO;
import com.brunohfc.restapi205.demo.data.dto.v2.PersonDTOV2;
import com.brunohfc.restapi205.demo.mapper.ObjectMapper;
import com.brunohfc.restapi205.demo.mapper.PersonMapper;
import com.brunohfc.restapi205.demo.model.Person;
import com.brunohfc.restapi205.demo.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper personMapper;



    public Page<PersonDTO> findAll(Pageable pageable){

        var peoples =repository.findAll(pageable);
        var linkPeople = peoples.map(person -> {
                    var dto = ObjectMapper.parseObject(person, PersonDTO.class);
                    createHateoasLink(dto);
                    return dto;
                }

                );

        return linkPeople;
    }

    public PersonDTO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));
        var dto =   ObjectMapper.parseObject(entity, PersonDTO.class);

        createHateoasLink(dto);
        return dto;

    }

    public PersonDTO create(PersonDTO person){
        var entity = ObjectMapper.parseObject(person, Person.class);

        var dto = ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);

        createHateoasLink(dto);
        return dto;
    }

    public PersonDTOV2 createv2(PersonDTOV2 person){

        var entity = personMapper.convertDTOtoEntity(person);

        return  personMapper.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person){

        Person entity = repository.
                findById(person.getId()).orElseThrow(() -> new NoSuchElementException("Id não encontrado"));

        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        var dto = ObjectMapper.parseObject(repository.save(entity),PersonDTO.class);
        createHateoasLink(dto);
        return dto;
    }

    @Transactional
    public PersonDTO disablePerson(Long id) {

        //validando se o item existe
        repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Não encontrado"));

        //existindo desabilita
        repository.disabledPerson(id);

        //prossegue com o fluxo
        var entity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Erro ao atualizar pessoa"));

        var dto = ObjectMapper.parseObject(entity,PersonDTO.class);
        createHateoasLink(dto);
        return dto;

    }

    public void delete(Long id){
        var validatePerson = findById(id);
        if(validatePerson != null){
            repository.deleteById(id);
        }

    }

    private static void createHateoasLink(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).getPerson(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).deleteById(dto.getId())).withRel("delete").withType("DELETE"));
        dto.add(linkTo(methodOn(PersonController.class).disablePerson(dto.getId())).withRel("disable").withType("PATCH"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("put").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).listPerson(0,10)).withSelfRel().withType("GET"));
    }




}
