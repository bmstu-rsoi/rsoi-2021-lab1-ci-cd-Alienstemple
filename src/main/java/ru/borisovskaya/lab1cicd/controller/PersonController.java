package ru.borisovskaya.lab1cicd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.borisovskaya.lab1cicd.model.Person;
import ru.borisovskaya.lab1cicd.repository.PersonRepository;
import ru.borisovskaya.lab1cicd.service.PersonService;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
    }
    @Autowired
    private PersonRepository personRepository;

    // TODO: add http responce codes, links to classes
    @GetMapping("/persons")  // TODO: Json output, params
    public List<Person> listAll() {
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable(value = "id") Integer id) {
        //Person pers = personRepository.findById(id)
        //        .orElseThrow();
        return personService.getPerson(id);     // TODO: exception handling ResponseEntity
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person newPerson) {  // TODO: add @Valid
        return personService.createPerson(newPerson);
    }

    @PatchMapping("/persons/{id}"/*, consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE]*/)
    public Person editPerson(@PathVariable(value = "id") Integer id, @RequestBody Person newPerson) {
        return personService.editPerson(id, newPerson);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable(value = "id") Integer id) /*throws ResourceNotFoundException */ {
        personService.deletePerson(id);
    }
}