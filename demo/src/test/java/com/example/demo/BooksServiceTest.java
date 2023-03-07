package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.model.BookDTO;
import com.example.demo.repository.BooksRepository;
import com.example.demo.service.BooksService;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BooksServiceTest {


    BooksService booksService;
    BooksRepository booksRepositoryMock;


    @BeforeEach
    void setup() {

        System.out.println("setupBeforeTest");
        booksRepositoryMock = mock(BooksRepository.class);

        this.booksService = new BooksService(booksRepositoryMock);
    }

    @AfterEach
    void deleteSetup() {
        System.out.println("deleteSetup");
    }

    @Test
    public void testAddBook() {
        boolean exists = true;
        assertThat(exists).isEqualTo(booksService.addBook("testBook"));
    }

    @Test
    public void testGetAllBooks() {


//        given
        Iterable<Book> iterator = Arrays.asList
                       (new Book("one"),
                        new Book("two"),
                        new Book("three"));

        Iterable <Book>emptyIterable = List.of();

        when(this.booksRepositoryMock.findAll())
                .thenReturn((Iterable<Book>) iterator)
                .thenReturn(emptyIterable);
//        when
        List<BookDTO> actual = booksService.getAll();
        List<BookDTO> actual1 = booksService.getAll();

//        then
        Assertions.assertAll(
                ()-> assertEquals(3, actual.size()),
                ()->assertEquals(0,actual1.size()));


    }

}
