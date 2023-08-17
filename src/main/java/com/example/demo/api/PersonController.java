package com.example.demo.api;

import com.example.demo.service.PersonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.person;
@RequestMapping("api/V1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody person per){
        personService.addPerson(per);
    }
    @GetMapping
    public List<person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path ="{id}")
    public person getPersonById(@PathVariable("id") UUID id){
        return personService.getPerson(id).orElse(null);
    }
    @DeleteMapping(path ="{id}")
    public void delPerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void upPerson(@PathVariable("id") UUID id,@Valid@NotNull @RequestBody person per){
        personService.updatePersonID(id, per);
    }
}
