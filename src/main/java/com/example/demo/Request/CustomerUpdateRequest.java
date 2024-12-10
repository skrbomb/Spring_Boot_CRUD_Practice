package com.example.demo.Request;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
