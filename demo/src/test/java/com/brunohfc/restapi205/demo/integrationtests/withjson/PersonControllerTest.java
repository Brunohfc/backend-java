package com.brunohfc.restapi205.demo.integrationtests.withjson;

import com.brunohfc.restapi205.demo.integrationtests.AbstractIntegrationTest;
import com.brunohfc.restapi205.demo.integrationtests.data.dto.PersonDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonControllerTest extends AbstractIntegrationTest {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;

    private static PersonDTO person;
    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        person = new PersonDTO();
    }
    @Test
    @Order(1)
    void create() {

    }


    @Test
    void listPerson() {
    }

    @Test
    void testCreate() {
    }

    @Test
    void getPerson() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}