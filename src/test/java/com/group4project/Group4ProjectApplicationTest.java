package com.group4project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest()
class Group4ProjectApplicationTest {


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
