package oops;

public class Abstraction {

	public static void main(String[] args) {
		
		// We can't make objects of Abstract class
/*		Car c1 = new Car();
		c1.start()
*/
		Audi a = new Audi();
		a.start();
		a.driving();
		
	}

}


class BMW extends Car{

	@Override
	void start() {
		System.out.println("BMW is started");
	}
	
}


class Audi extends Car {

	@Override
	void start() {
		System.out.println("Audi is started");
	}
	
}

abstract class Car {
	int price;
	abstract void start();
	
	// we can define methods within abstract also;
	void driving() {
		System.out.println("Car is driving");
	}
}
