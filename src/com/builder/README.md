#Builder example

Haremos lo siguiente:

1. Crearemos una clase llamada `Person` con las siguientes propiedades y metodos.
```java
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


2. Vamos a crear una clase estática anidada (será la clase Builder).
  1. Vamos a seguir las convenciones de nombres, asi que si el nombre de nuestra clase es `Person` la clase Builder se llamará `PersonBuilder`.
  2. La clase builder deberá tener un constructor público.
  3. La clase builder deberá tener metodos para definir las propiedades del objeto y `retornar la clase builder`.
  4. El paso final sera definir un método `build()` en la clase builder que retornará el objeto que el programa necesita. Para esto necesitaremos un constructor privado en la clase `Person` recibiendo un objeto tipo `PersonBuilder`.
  5. Crearemos un método `toString()` en la clase `Person` para efectos de tests.
```java
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

    public String toString() {
        return "Name=" + this.firstName + "   Lastname=" + this.lastName + "    Email=" + this.email + "   Address=" + this.address + "   Phone=" + this.phone;
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

3. Ahora, crearemos una clase llamada TestBuilder para probar nuestra clase `Person`

```java
public class Main {
    public static void main(String[] args) {
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
```

4. Verás una salida como esta:

```java Name=Fernando   Lastname=Calderon    Email=fcalderon@nearsoft.com   Address=Calle Pinos   Phone=901923 ```

