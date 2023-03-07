package com.example.demo.model;


import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table
public class Book {


    @Id
    @Column
    @javax.persistence.Id
    private UUID id;
    @Column(unique = true)
    private String name;

    public Book() {

    }

    public Book(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String fileName) {
        this.name = fileName;
    }


}
