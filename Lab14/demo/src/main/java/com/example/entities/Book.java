package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{book.isbn.absent}")
    private String isbn;

    @NotEmpty(message = "{book.title.absent}")
    private String title;

    @NotEmpty(message = "{book.author.absent}")
    private String author;

    @NotNull(message = "{book.price.absent}")
    @Range(min = 0, max = 1000000, message = "{book.price.invalid}")
    private BigDecimal price;

    public Book(String isbn, String title, String author, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}