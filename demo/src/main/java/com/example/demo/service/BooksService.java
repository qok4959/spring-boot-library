package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BooksService {

    @Autowired
    private BookRepository booksRepository;

    public Iterable<Book> getAll() {
        return booksRepository.findAll();
    }

    public void addBook(String name) {

        try {
            Book newBook = new Book();
            System.out.println(name);
            newBook.setName(name);

            newBook.setId(UUID.randomUUID());

            booksRepository.save(newBook);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("book already exists");
        }

    }
}
