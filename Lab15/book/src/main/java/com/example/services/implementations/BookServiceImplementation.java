package com.example.services.implementations;

import com.example.entities.Book;
import com.example.exceptions.BookNotFoundException;
import com.example.repositories.BookRepository;
import com.example.services.BookService;
import com.example.services.aspect.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookService")
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Loggable
    @Override
    public Book getById(int id) {
        return bookRepository.findById(id)
                                .orElseThrow(() -> new BookNotFoundException("book with id:" + id + " not found."));
    }

    @Loggable
    @Override
    public Book getByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        if(book == null)
            throw new BookNotFoundException("book with title:" + title + " not found.");
        return book;
    }

    @Loggable
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Loggable
    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Loggable
    @Override
    public Book updateBook(int id, Book book) {
        Book bookToUpdate = getById(id);
        bookToUpdate.setPrice(book.getPrice());
        bookRepository.save(bookToUpdate);
        return bookToUpdate;
    }

    @Loggable
    @Override
    public void removeBook(int id) {
        Book bookToDelete = getById(id);
        bookRepository.delete(bookToDelete);
    }
}
