package com.group4project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Group4ProjectApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void greetingShouldReturnDefaultMessage() {
        this.webTestClient
                .get()
                .uri("products/67431224/")
                .exchange()
                .expectBody()
                .jsonPath("$productID").isEqualTo(67431224);

    }


    @Test
    public void loadWhenRun() {
    }

    @Test
    void provideJsonResponseThatMatchesCorrespondingFile() {

    }

    @Test
    void notIncludeDateCreatedInReturnedJson() {

    }

    @Test
    void notIncludeIsoCountryCodeInReturnedJson() {

    }

    @Test
    void convertIsoCountryCodeToFullCountryName() {

    }

    @Test
    void returnAppropriateErrorMessageWhenNoMatchingProductId() {

    }
}
