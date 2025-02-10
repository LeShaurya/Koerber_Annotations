package com.library.controllers;

import com.library.entity.Book;
import com.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping(path="books/{id}")
    public Book getById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PostMapping(path="books/save")
    public ResponseEntity<Book> save(@Valid @RequestBody Book book){
        Book bookToAdd=bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookToAdd);
    }

    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    @PutMapping(path="books/update/{id}")
    public ResponseEntity<Book> update(@PathVariable int id,@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, book));
    }

    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    @DeleteMapping("books/delete/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable int id) {
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
