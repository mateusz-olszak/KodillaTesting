package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = new User("user1");

        Optional<User> optionalUser = Optional.ofNullable(user);

        String name = optionalUser.orElse(new User("No data")).getName();

        optionalUser.ifPresent(u -> System.out.println(user.getName()));

    }
}
