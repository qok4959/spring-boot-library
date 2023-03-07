package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;
import com.example.demo.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BooksService {


    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<BookDTO> getAll() {
        return StreamSupport
                .stream(booksRepository.findAll().spliterator(), false)
                .map(book -> new BookDTO(book.getName()))
                .collect(Collectors.toList());
    }


    public boolean addBook(String name) {

        try {
            Book newBook = new Book();
            System.out.println(name);
            newBook.setName(name);

            newBook.setId(UUID.randomUUID());

            booksRepository.save(newBook);
            return false;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("book already exists");

            return true;
        }


    }


}
