package com.library.services.implementations;

import com.library.entity.Book;
import com.library.exceptions.BookNotFoundException;
import com.library.repositories.BookRepository;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("book with id: " + id + "not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book bookToUpdate = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("NOok not found"));
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setCategory(book.getCategory());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPrice(book.getPrice());
        return bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBookById(int id) {
        Book bookById = getBookById(id);
        bookRepository.delete(bookById);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
