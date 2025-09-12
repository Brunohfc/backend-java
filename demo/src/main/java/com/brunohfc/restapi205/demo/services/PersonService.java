package com.brunohfc.restapi205.demo.services;

import com.brunohfc.restapi205.demo.data.dto.v1.PersonDTO;
import com.brunohfc.restapi205.demo.data.dto.v2.PersonDTOV2;
import com.brunohfc.restapi205.demo.mapper.ObjectMapper;
import com.brunohfc.restapi205.demo.model.Person;
import com.brunohfc.restapi205.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<PersonDTO> findAll(){
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);

    }

    public PersonDTO getById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));
        return  ObjectMapper.parseObject(entity, PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person){
        var entity = ObjectMapper.parseObject(person, Person.class);

        return  ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }
    public PersonDTOV2 createv2(PersonDTOV2 person){
        var entity = ObjectMapper.parseObject(person, Person.class);

        return  ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){

        Person entity = repository.
                findById(person.getId()).orElseThrow(() -> new NoSuchElementException("Id não encontrado"));

        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        return ObjectMapper.parseObject(repository.save(entity),PersonDTO.class);
    }

    public void delete(Long id){
        var validatePerson = getById(id);
        if(validatePerson != null){
            repository.deleteById(id);
        }



    }




}
