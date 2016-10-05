#Builder example

1. Primero tienes que crear una clase estatica anidada (Sera la clase Builder). Vamos a seguir las convenciones de nombres, asi que si el nombre de nuestra clase es `Person` la clase Builder se llamará `PersonBuilder`.
2. La clase builder deberá tener un constructor público.
3. La clase builder deberá tener metodos para definir las propiedades del objeto y `retornar la clase builder`.
4. El paso final sera definir un método `build()` en la clase builder que retornará el objeto que el programa necesita. Para esto necesitaremos un constructor privado en la clase `Person` recibiendo un objeto tipo `PersonBuilder`.