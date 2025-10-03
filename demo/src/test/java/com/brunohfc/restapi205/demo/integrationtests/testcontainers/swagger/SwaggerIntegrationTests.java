package com.brunohfc.restapi205.demo.integrationtests.testcontainers.swagger;


import com.brunohfc.restapi205.demo.integrationtests.testcontainers.AbstractIntegrationTest;
import config.TestConfigs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class SwaggerIntegrationTests extends AbstractIntegrationTest {

    @Test
    void shouldDisplaySwaggerUiPage(){


       var pageContent = given()
               .basePath("/swagger-ui/index.html")
                .port(TestConfigs.SERVER_PORT)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        assertTrue(pageContent.contains("Swagger UI"));

    }
}
