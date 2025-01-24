package com.book_app.services;

import com.book_app.annotations.Loggable;
import com.book_app.models.Book;
import com.book_app.repositories.BookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter
@Setter
@Service(value = "bookService")
@Transactional
public class BookServiceImplementation implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Loggable
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    @Override
    @Loggable
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
