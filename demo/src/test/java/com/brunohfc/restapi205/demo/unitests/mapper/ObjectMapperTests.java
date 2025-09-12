package com.brunohfc.restapi205.demo.unitests.mapper;


import static com.brunohfc.restapi205.demo.mapper.ObjectMapper.parseListObjects;
import static com.brunohfc.restapi205.demo.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import com.brunohfc.restapi205.demo.data.dto.v1.PersonDTO;
import com.brunohfc.restapi205.demo.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ObjectMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = parseObject(inputObject.mockEntity(), PersonDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getNome());
        assertEquals("Last Name Test0", output.getSobrenome());
        assertEquals("Address Test0", output.getEndereco());
        assertEquals("Male", output.getGenero());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
        PersonDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getNome());
        assertEquals("Last Name Test0", outputZero.getSobrenome());
        assertEquals("Address Test0", outputZero.getEndereco());
        assertEquals("Male", outputZero.getGenero());

        PersonDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getNome());
        assertEquals("Last Name Test7", outputSeven.getSobrenome());
        assertEquals("Address Test7", outputSeven.getEndereco());
        assertEquals("Female", outputSeven.getGenero());

        PersonDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getNome());
        assertEquals("Last Name Test12", outputTwelve.getSobrenome());
        assertEquals("Address Test12", outputTwelve.getEndereco());
        assertEquals("Male", outputTwelve.getGenero());
    }

    @Test
    public void parseDTOToEntityTest() {
        Person output = parseObject(inputObject.mockDTO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getNome());
        assertEquals("Last Name Test0", output.getSobrenome());
        assertEquals("Address Test0", output.getEndereco());
        assertEquals("Male", output.getGenero());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObjects(inputObject.mockDTOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getNome());
        assertEquals("Last Name Test0", outputZero.getSobrenome());
        assertEquals("Address Test0", outputZero.getEndereco());
        assertEquals("Male", outputZero.getGenero());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getNome());
        assertEquals("Last Name Test7", outputSeven.getSobrenome());
        assertEquals("Address Test7", outputSeven.getEndereco());
        assertEquals("Female", outputSeven.getGenero());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getNome());
        assertEquals("Last Name Test12", outputTwelve.getSobrenome());
        assertEquals("Address Test12", outputTwelve.getEndereco());
        assertEquals("Male", outputTwelve.getGenero());
    }
}