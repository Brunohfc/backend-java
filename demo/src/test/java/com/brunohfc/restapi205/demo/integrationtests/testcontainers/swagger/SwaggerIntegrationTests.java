package com.brunohfc.restapi205.demo.integrationtests.testcontainers.swagger;

import com.brunohfc.restapi205.demo.integrationtests.testcontainers.AbstractIntegrationTest;
import config.TestConfigs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SwaggerIntegrationTests extends AbstractIntegrationTest {

    @LocalServerPort
    int port;

    @Test
    void shouldDisplaySwaggerUiPage(){


       var pageContent = given()
               .basePath("/swagger-ui/index.html")
                .port(port)
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
