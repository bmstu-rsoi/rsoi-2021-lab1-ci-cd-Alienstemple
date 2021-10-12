package ru.borisovskaya.lab1cicd.service;

import org.springframework.stereotype.Component;
import ru.borisovskaya.lab1cicd.model.Person;

import java.util.List;

@Component
public interface PersonService {
    Person getPerson(Integer id);
    List<Person> getPersons();
    Person createPerson(Person request);
    Person editPerson(Integer id, Person request);
    void deletePerson(Integer id);
}
