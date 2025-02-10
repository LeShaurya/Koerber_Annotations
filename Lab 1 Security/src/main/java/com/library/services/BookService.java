package com.library.services;

import com.library.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getAllBooks();
    Book updateBook(int id, Book book);
    void deleteBookById(int id);
    Book addBook(Book book);
}
