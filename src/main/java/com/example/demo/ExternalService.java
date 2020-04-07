package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
   
@FeignClient("external-service")
public interface ExternalService {

    @GetMapping(value = "/health")
    String health();
}
