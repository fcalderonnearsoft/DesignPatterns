#Builder example

Haremos lo siguiente:

1. Crearemos una clase llamada `Person` con las siguientes propiedades y metodos.
```
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
}
```


2. Vamos a crear una clase estática anidada (será la clase Builder). Vamos a seguir las convenciones de nombres, asi que si el nombre de nuestra clase es `Person` la clase Builder se llamará `PersonBuilder`.
  1. La clase builder deberá tener un constructor público.
  ... La clase builder deberá tener metodos para definir las propiedades del objeto y `retornar la clase builder`.
  ..* El paso final sera definir un método `build()` en la clase builder que retornará el objeto que el programa necesita. Para esto necesitaremos un constructor privado en la clase `Person` recibiendo un objeto tipo `PersonBuilder`.


```
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

}
```


