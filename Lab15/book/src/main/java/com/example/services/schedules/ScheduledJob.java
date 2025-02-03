package com.example.services.schedules;

import com.example.entities.Book;
import com.example.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledJob {
    private Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    @Autowired
    private BookService service;

    @Scheduled(cron = "0,30 * * * * *")
    public void cronJob() {
        logger.info("> cronJob");

        List<Book> products = service.getAllBooks();
        logger.info("There are {} products in the data store.", products.size());

        logger.info("< cronJob");
    }


    @Scheduled(initialDelay = 5000, fixedRate = 15000)
    public void fixedRateJob() {
        logger.info("> fixedRateJob");

        List<Book> products = service.getAllBooks();

        logger.info("There are {} books in the data store.", products.size());

        logger.info("< fixedRateJob");
    }
}
