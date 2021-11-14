package com.example.consumingrest.controller;

import java.io.IOException;

import com.example.consumingrest.Quote;
import com.example.consumingrest.service.SampleApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

    private final SampleApi sampleApi;

    EmployeeController(SampleApi sampleApi) {
        this.sampleApi = sampleApi;
    }


    @GetMapping("/quote")
    Quote quote() throws IOException {
        Quote quote =  this.sampleApi.getQuote();
        return quote;
    }


}