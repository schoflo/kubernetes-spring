package com.schoflo.kubernetesspring.controller;

import com.schoflo.kubernetesspring.entity.Beer;
import com.schoflo.kubernetesspring.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerRepository beerRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/greeting-admin")
    public String greetingAdmin(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @PostMapping("/createBeer")
    public Beer createBeer(@RequestParam(name = "name", required = false, defaultValue = "Siegel") String name) {
        return beerRepo.save(Beer.builder().name(name).brewery("Union").alcohol(4.9).build());
    }

    @GetMapping("/getBeers")
    public List<Beer> getBeers() {
        return beerRepo.findAll();
    }

}
