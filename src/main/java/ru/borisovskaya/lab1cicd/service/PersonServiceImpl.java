package ru.borisovskaya.lab1cicd.service;

import org.springframework.stereotype.Service;
import ru.borisovskaya.lab1cicd.model.Person;
import ru.borisovskaya.lab1cicd.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPerson(Integer id) {
        Person pers = personRepository.findById(id)
                .orElseThrow();
        return pers;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(Person request) {
        return personRepository.save(request);
    }

    @Override
    public Person editPerson(Integer id, Person request) {
        Person pers = personRepository.findById(id)
                .orElseThrow();

        pers.setName(request.getName());
        pers.setAge(request.getAge());
        pers.setAddress(request.getAddress());
        pers.setWork(request.getWork());
        return personRepository.save(pers);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
