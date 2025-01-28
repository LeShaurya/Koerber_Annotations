package com.example.services;

import com.example.entities.Book;
import java.util.List;

public interface BookService {
    Book getById(int id);
    Book getByTitle(String title);
    List<Book> getAllBooks();
    Book addBook(Book book);
    Book updateBook(int id, Book book);
    void removeBook(int id);
}