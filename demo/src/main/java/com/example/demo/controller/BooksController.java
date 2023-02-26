package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/allBooks")
    public Iterable<Book> getAllBooks() {
        return bookService.getAll();
    }

    @PostMapping("/addBook")
    public void addBook(@RequestParam("name") String name){

        bookService.addBook(name);
    }


}
