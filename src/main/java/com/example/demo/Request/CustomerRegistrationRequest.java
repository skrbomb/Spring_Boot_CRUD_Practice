package com.example.demo.Request;

public record CustomerRegistrationRequest (
        String name,
        String email,
        Integer age
){
}
