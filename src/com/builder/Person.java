package com.builder;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private Integer phone;
    private String email;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Person(PersonBuilder build) {
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.address = build.address;
        this.phone = build.phone;
        this.email = build.email;
    }

    //Builder Class
    public static class PersonBuilder {

        private String firstName;
        private String lastName;
        private String address;
        private Integer phone;
        private String email;

        public PersonBuilder(){
        }

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setPhone(Integer phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }

    @Override
    public String toString() {
        return "Name=" + this.firstName + "   Lastname=" + this.lastName + "    Email=" + this.email;
    }
}
