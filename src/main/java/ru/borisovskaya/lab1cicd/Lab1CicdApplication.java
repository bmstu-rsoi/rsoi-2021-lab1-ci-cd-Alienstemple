package ru.borisovskaya.lab1cicd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Lab1CicdApplication {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Lab1CicdApplication.class, args);
    }

    //@Override
    public void run(String... args) throws Exception {
//        var sql = "INSERT INTO persons (name, age, address, work) VALUES ('Sam', 15, 'street 1', 'nam company')";
//
//        int rows = jdbcTemplate.update(sql);
//            System.out.println("Rows now: " + rows);
    }
}
