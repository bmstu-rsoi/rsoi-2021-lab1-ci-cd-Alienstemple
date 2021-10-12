package ru.borisovskaya.lab1cicd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.borisovskaya.lab1cicd.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
