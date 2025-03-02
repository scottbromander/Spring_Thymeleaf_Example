package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataController {
    @GetMapping("/data")
    public List<Map<String, String>> getData() {
        return List.of(
                Map.of("id", "1", "name", "Alice"),
                Map.of("id", "2", "name", "Bob"),
                Map.of("id", "3", "name", "Charlie")
        );
    }
}
