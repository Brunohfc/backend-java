package com.brunohfc.restapi205.demo.services;

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

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person getById(Long id){

        return  repository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));

    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update(Person person){

        Person entity = getById(person.getId());

        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        return  repository.save(entity);
    }

    public void delete(Long id){
        var validatePerson = getById(id);
        if(validatePerson != null){
            repository.deleteById(id);
        }



    }




}
