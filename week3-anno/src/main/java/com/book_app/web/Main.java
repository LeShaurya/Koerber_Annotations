package com.book_app.web;

import com.book_app.service.BookService;
import com.config.AutoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        BookService bs = (BookService) context.getBean("bookService");
        System.out.println(bs.getAllBooks());
        System.out.println(bs.getBookById(1));
        System.out.println(bs.getBookById(2));
    }
}