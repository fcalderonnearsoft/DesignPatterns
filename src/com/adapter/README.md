#Adapter example

Un buen ejemplo de Adapter es un cargador de celular. Los cargadores de celular necesitan 3V, pero los tomacorriente normales producen 120V.
Asi que el cargador de celular funciona como un adaptador entre el socket del celular y el tomacorriente de la pared.

Asi que, haremos lo siguiente:

1. Crearemos 2 clases, `Volt` (para medir los volts) y `Socket` (tomacorriente, produciendo 120V)
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


```
public class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}
```

2. Ahora, crearemos una clase `Adaptador` que produzca salidas de 3V, 12V o el default 120V.

```
public class SocketAdapterImpl extends Socket{

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

3. Ahora, crearemos una clase para consumir nuestra implementación de adaptador:

```
public class AdapterPatternTest {

	public static void main(String[] args) {

	SocketAdapter sockAdapter = new SocketAdapterImpl();
    		Volt v3 = getVolt(sockAdapter,3);
    		Volt v12 = getVolt(sockAdapter,12);
    		Volt v120 = getVolt(sockAdapter,120);
    		System.out.println("v3 volts usando la clase adaptador="+v3.getVolts());
    		System.out.println("v12 volts usando la clase adaptado="+v12.getVolts());
    		System.out.println("v120 volts usando la clase adaptado="+v120.getVolts());
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

4. Verás una salida como esta:
``` v3 volts usando la clase adaptador=3
    v12 volts usando la clase adaptado=12
    v120 volts usando la clase adaptado=120
    ```

