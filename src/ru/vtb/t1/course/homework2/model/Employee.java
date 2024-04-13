package ru.vtb.t1.course.homework2.model;

public class Employee {

    public Employee(String name, Integer age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Position getPosition() {
        return position;
    }

    private final String name;

    private final Integer age;

    private final Position position;

}
