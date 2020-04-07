package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties ="spring.sleuth.feign.enabled=true" )
@AutoConfigureStubRunner(ids = { "org:external-service:stubs" })
public class ExternalServiceIntegrationTest {

    @Autowired
    private ExternalService externalService;

    @Test
    public void checkHealthWithTracing() {
        String message = externalService.health();

        assertEquals(message, "Feeling better than ever!");
    }

}
