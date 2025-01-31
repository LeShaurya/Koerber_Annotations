package com.example.controller;

import com.example.entities.InformationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @Autowired
    private InformationData informationData;

    @GetMapping("/helloInfo")
    public InformationData informationDataSend() {
        return informationData;
    }

}
