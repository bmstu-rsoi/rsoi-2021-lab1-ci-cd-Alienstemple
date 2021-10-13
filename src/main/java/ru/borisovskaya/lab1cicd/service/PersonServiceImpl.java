package ru.borisovskaya.lab1cicd.service;

import org.springframework.stereotype.Service;
import ru.borisovskaya.lab1cicd.model.Person;
import ru.borisovskaya.lab1cicd.repository.PersonRepository;

import javax.persistence.EntityNotFoundException;
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
                .orElseThrow(EntityNotFoundException::new);
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
        Person pers = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        pers.setName(request.getName());
        if (request.getAge() != null)
            pers.setAge(request.getAge());
        if (request.getAddress() != null)
            pers.setAddress(request.getAddress());
        if (request.getWork() != null)
            pers.setWork(request.getWork());
        return personRepository.save(pers);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
