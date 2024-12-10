package com.example.demo.Response;

import com.example.demo.entity.Person;

import java.util.List;

public class GreetResponse {
    private  String greeting;
    private List<String> language;
    private Person person;

    public GreetResponse(String greeting, List<String> language, Person person) {
        this.greeting = greeting;
        this.language = language;
        this.person = person;
    }

    public String getGreeting() {
        return greeting;
    }

    public Person getPerson() {
        return person;
    }

    public List<String> getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "GreetResponse{" +
                "greeting='" + greeting + '\'' +
                ", language=" + language +
                ", person=" + person +
                '}';
    }
}
