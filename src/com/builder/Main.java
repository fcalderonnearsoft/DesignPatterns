package com.builder;

public class Main {
    public static void main(String[] args) {
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Person person = new Person.PersonBuilder()
                .setFirstName("Fernando")
                .setLastName("Calderon")
                .setAddress("Calle Pinos")
                .setEmail("fcalderon@nearsoft.com")
                .setPhone(901923)
                .build();

        System.out.println(person);
    }
}
