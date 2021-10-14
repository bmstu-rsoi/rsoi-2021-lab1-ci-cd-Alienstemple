package ru.borisovskaya.lab1cicd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.borisovskaya.lab1cicd.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
