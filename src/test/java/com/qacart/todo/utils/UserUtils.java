package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {

    public User generateRandomUser(){

        Faker faker = new Faker();

        String firstName= faker.name().firstName();
        String lastName= faker.name().lastName();
        String email= faker.internet().emailAddress();
        String password= faker.internet().password();

        User user = new User(firstName, lastName, email, password);

        return user;
    }
}
