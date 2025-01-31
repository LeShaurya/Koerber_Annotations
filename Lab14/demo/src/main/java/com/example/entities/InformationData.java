package com.example.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class InformationData {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> phoneNumbers;
}
