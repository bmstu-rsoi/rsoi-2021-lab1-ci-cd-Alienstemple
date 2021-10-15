package ru.borisovskaya.lab1cicd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.borisovskaya.lab1cicd.model.Person;
import ru.borisovskaya.lab1cicd.repository.PersonRepository;
import ru.borisovskaya.lab1cicd.service.PersonService;
import org.springframework.ui.Model;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons", produces = "application/json")
    public ResponseEntity<Object> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersons());
    }

    @GetMapping(value = "/persons/{id}", produces = "application/json")
    public ResponseEntity<Object> getPerson(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(id));
    }

    @PostMapping(value = "/persons", consumes = "application/json")
    public ResponseEntity<Object> createPerson(@Valid @RequestBody Person newPerson) {
        personService.createPerson(newPerson);
        String location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPerson.getId())
                .toUriString();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.LOCATION, location);
        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeaders).body(newPerson);
    }

    @PatchMapping(value = "/persons/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity<Object> editPerson(@PathVariable(value = "id") Integer id, @Valid @RequestBody Person newPerson) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.editPerson(id, newPerson));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable(value = "id") Integer id) /*throws ResourceNotFoundException */ {
        personService.deletePerson(id);
    }
}