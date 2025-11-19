package com.brunohfc.restapi205.demo.mapper;

import com.brunohfc.restapi205.demo.data.dto.v2.PersonDTOV2;
import com.brunohfc.restapi205.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person){
        PersonDTOV2 p2 = new PersonDTOV2();
        p2.setId(person.getId());
        p2.setEndereco(person.getEndereco());
        p2.setGenero(person.getGenero());
        p2.setNome(person.getNome());
        p2.setSobrenome(person.getSobrenome());
        // TODO implementado no model ainda
        // p2.setDataNascimento(new Date());

        return p2;

    }

    public Person convertDTOtoEntity(PersonDTOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());

        return entity;
    }
}
