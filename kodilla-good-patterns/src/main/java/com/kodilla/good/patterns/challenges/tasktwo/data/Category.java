package com.kodilla.good.patterns.challenges.tasktwo.data;

public class Category {

    private final String name;
    private final String description;

    public Category(final String name,final String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
