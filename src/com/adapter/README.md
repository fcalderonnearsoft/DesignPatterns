#Adapter example

Haremos lo siguiente:

1. Crearemos una clase llamada `Person` con las siguientes propiedades y metodos.
```
public class Volt {

	private int volts;

	public Volt(int v){
		this.volts=v;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}

}
```


2. Vamos a crear una clase estática anidada (será la clase Builder).
  1. Vamos a seguir las convenciones de nombres, asi que si el nombre de nuestra clase es `Person` la clase Builder se llamará `PersonBuilder`.
  2. La clase builder deberá tener un constructor público.
  3. La clase builder deberá tener metodos para definir las propiedades del objeto y `retornar la clase builder`.
  4. El paso final sera definir un método `build()` en la clase builder que retornará el objeto que el programa necesita. Para esto necesitaremos un constructor privado en la clase `Person` recibiendo un objeto tipo `PersonBuilder`.
  5. Crearemos un método `toString()` en la clase `Person` para efectos de tests.
```
public class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}
```

3. Ahora, crearemos una clase llamada TestBuilder para probar nuestra clase `Person`

```
public class SocketClassAdapterImpl extends Socket{

	public Volt get120Volt() {
		return getVolt();
	}

	public Volt get12Volt() {
		Volt v= getVolt();
		return convertVolt(v,10);
	}

	public Volt get3Volt() {
		Volt v= getVolt();
		return convertVolt(v,40);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts()/i);
	}

}
```

4. Verás una salida como esta:

```
public class AdapterPatternTest {

	public static void main(String[] args) {

		testClassAdapter();
		testObjectAdapter();
	}

	private static void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());
	}

	private static void testClassAdapter() {
		SocketAdapter sockAdapter = new SocketClassAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Class Adapter="+v3.getVolts());
		System.out.println("v12 volts using Class Adapter="+v12.getVolts());
		System.out.println("v120 volts using Class Adapter="+v120.getVolts());
	}

	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i){
		case 3: return sockAdapter.get3Volt();
		case 12: return sockAdapter.get12Volt();
		case 120: return sockAdapter.get120Volt();
		default: return sockAdapter.get120Volt();
		}
	}
}
```

