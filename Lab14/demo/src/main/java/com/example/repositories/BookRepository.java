package com.example.repositories;

import com.example.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "bookRepository")
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);
}
