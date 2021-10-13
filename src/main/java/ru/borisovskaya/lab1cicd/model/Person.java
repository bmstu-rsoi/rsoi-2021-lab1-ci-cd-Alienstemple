package ru.borisovskaya.lab1cicd.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false, length = 80)
    @NotEmpty
    private String name;

    @Column(name = "age", nullable = false)
    @NotNull
    private Integer age;

    @Column(name = "address", nullable = false)
    @NotNull
    private String address;

    @Column(name = "work", nullable = false)
    @NotNull
    private String work;

    public Person(String name, Integer age, String address, String work) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
        // For test output
        System.out.println(this.toString());
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(address, person.address) && Objects.equals(work, person.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address, work);
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", work='" + work + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age", nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "work", nullable = false)
    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
