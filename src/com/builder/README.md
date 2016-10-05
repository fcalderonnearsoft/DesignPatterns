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

    }
```


2. Vamos a crear una clase estática anidada (será la clase Builder). Vamos a seguir las convenciones de nombres, asi que si el nombre de nuestra clase es `Person` la clase Builder se llamará `PersonBuilder`.
3. La clase builder deberá tener un constructor público.
4. La clase builder deberá tener metodos para definir las propiedades del objeto y `retornar la clase builder`.
5. El paso final sera definir un método `build()` en la clase builder que retornará el objeto que el programa necesita. Para esto necesitaremos un constructor privado en la clase `Person` recibiendo un objeto tipo `PersonBuilder`.


