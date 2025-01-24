package com.book_app;

import com.book_app.models.Book;
import com.book_app.services.BookService;
import com.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("All Books:");
        bookService.getAllBooks().forEach(System.out::println);

//        Book newBook = new Book(0, "9999999999999", "The Pragmatic Programmer", "Andy Hunt", 49.95);
//        Book addedBook = bookService.addBook(newBook);
//        System.out.println("Added Book: " + addedBook);
//
//        Book retrievedBook = bookService.getBookById(addedBook.getId());
//        System.out.println("Retrieved Book by ID: " + retrievedBook);
//
//        retrievedBook.setPrice(54.95);
//        bookService.updateBook(retrievedBook.getId(), retrievedBook);
//        System.out.println("Updated Book: " + bookService.getBookById(retrievedBook.getId()));
//
//        bookService.deleteBook(retrievedBook.getId());
//        System.out.println("Book deleted. All Books:");
//        bookService.getAllBooks().forEach(System.out::println);

        context.close();
    }
}
