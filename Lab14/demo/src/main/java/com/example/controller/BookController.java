package com.example.controller;

import com.example.entities.Book;
import com.example.entities.InformationData;
import com.example.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class BookController {

    @Autowired
    private InformationData informationData;

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("books/title/{title}")
    public ResponseEntity<Book> getByTitle(@PathVariable String title) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByTitle(title));
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> getByTitle(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getById(id));
    }

    @PostMapping("books")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
        Book bookToAdd = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookToAdd);
    }

    @PutMapping("books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, book));
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable int id) {
        bookService.removeBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/helloInfo")
    public ResponseEntity<InformationData> informationDataSend() {
        return ResponseEntity.status(HttpStatus.OK).body(informationData);
    }
}
