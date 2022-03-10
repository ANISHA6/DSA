package oops;

public class Interfaces implements Project{
	
	public static void main(String args[]) {
		Interfaces obj1 = new Interfaces();
		obj1.start();
		
		
		Tranformer obj2 = new Tranformer();
		obj2.start();
		obj2.eat();
	}

	@Override
	public void start() {
		System.out.println("My car is starting");
		
	}
}


// Achieving multiple inheritance by implementing multiple interfaces
class Tranformer implements Project, Boy{
	
	@Override
	public void eat() {
		System.out.println("He is eating");
		
	}

	@Override
	public void start() {
		System.out.println("He is loaded");
		
	}
	
}


interface Project{
	
	void start();
}

interface Boy{
	void eat();
}
