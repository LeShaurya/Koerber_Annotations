package com.book_app.repositories;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book(int id, String isbn, String title, String author, double price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

