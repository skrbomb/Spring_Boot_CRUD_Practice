package com.example.demo.entity;

public class Person {
    private final String name;
    private final Integer age;
    private final double savings;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSavings() {
        return savings;
    }

    public Person(String name, Integer age, double savings) {
        this.name = name;
        this.age = age;
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", savings=" + savings +
                '}';
    }
}
