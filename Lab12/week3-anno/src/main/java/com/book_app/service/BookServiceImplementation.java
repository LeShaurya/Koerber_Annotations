package com.book_app.service;

import com.book_app.repositories.Book;
import com.book_app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookService")
public class BookServiceImplementation implements BookService{

    @Autowired
    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        bookRepository.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

}
