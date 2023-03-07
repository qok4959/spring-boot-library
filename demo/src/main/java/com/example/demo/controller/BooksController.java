package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;
import com.example.demo.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    BooksService bookService;

    BooksController(BooksService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {

        System.out.println();
        List<BookDTO> books = bookService.getAll();

        
        System.out.println(books);
//        books = bookService.getAll();
        List<BookDTO> book2 = books;
        System.out.println(book2.get(3).getName());
        return books;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/add/book/{name}")
    public void addBook(@PathVariable("name") String name) {

        if (bookService.addBook(name))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "already exists");

        bookService.addBook(name);
    }




}
