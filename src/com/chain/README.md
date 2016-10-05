#Chain of responsability example

Un ejemplo de cadena de responsabilidad es un `Cajero automático`. El usuario ingresa la cantidad que desea retirar y la
maquina dispensa el monto en billetes de $50, $20, $10.

Asi que, haremos lo siguiente:

1. Crearemos la clase `Currency` que almacenará el monto que se dispensará
```
public class Currency {

	private int amount;

	public Currency(int amt){
		this.amount=amt;
	}

	public int getAmount(){
		return this.amount;
	}
}
```
2. Ahora crearemos tres implementaciones para los dispensadores de $50, $20 y $10.

`FiftyDollarDispenser.java`

```
public class FiftyDollarDispenser {

	private DispenseChain chain;

	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >= 50){
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}
```

`TwentyDollarDispenser.java`

```
public class TwentyDollarDispenser implements DispenseChain{

	private DispenseChain chain;

	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}
```

`TenDollarDispenser.java`

```
public class TenDollarDispenser implements DispenseChain {

	private DispenseChain chain;

	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >= 10){
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing "+num+" 10$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}
```

3. Ahora, crearemos la lógica de la cadena. Debemmos de ser muy cuidadosos en este punto.

```
public class ATMDispenseChain {

	private DispenseChain c1;

	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
			}
			else {
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
			}
		}

	}

}
```