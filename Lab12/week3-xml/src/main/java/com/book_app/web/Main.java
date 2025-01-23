package com.book_app.web;

import com.book_app.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
        BookService bs = (BookService) context.getBean("bookService");
    }
}