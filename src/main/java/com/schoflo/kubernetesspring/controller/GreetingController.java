package com.schoflo.kubernetesspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/greeting-admin")
    public String greetingAdmin(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

}
