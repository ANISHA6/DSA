package oops;

import encapsulation.EncapsultionIntro;

public class MainClass {

	public static void main(String[] args) {
		
		
		// For parent class Person
		/*
		Person p1 = new Person();
		p1.age = 24;
		p1.name = "Paritosh";
		
		System.out.print(p1.age + " " + p1.name);
		
		// OVERLOADED constructors
		Person p2 = new Person(25, "Kuch bhi");
		System.out.print(p2.age + " " + p2.name);
		
		// accessing the behaviour
		p1.eat();
		// p2.walk() and p2.walk(2) are the example of compile time polymorphism
		// because run time par hi hum bata sakte hai ki kis method ko call hoga
		p2.walk();
		p2.walk(2);
		
		System.out.println("Number of ojbect created: " + Person.count);
		
		*/
		
		// For child class Developer
		Developer d1 = new Developer(22, "Paritosh");
		d1.walk();	// d1.walk() because of inheritance property d1 tries to find walk() method in the nearest parent class
					// agar nearest parent me nahi milta then it will find out it nearest to nearest parent class and so on
		
		
		
		// ENCAPSULATION
		EncapsultionIntro obj = new EncapsultionIntro();
		obj.letsDoWork();	// we can acess letsDoWork because it is declared as public
	}

}


class Person{
	protected String name;
	int age;
	static int count;
	
	public Person(){
		count++;
		System.out.println("New object is created");
	}
	
	public Person(int a){
		count++;
		System.out.println(" hello dream bell");
	}
	
	public Person(int age, String name) {
		this();
		this.name = name;
		this.age = age;
	}
	
	
	void walk() {
		System.out.println(name + " is walking.");
	}
	
	void eat() {
		System.out.println(name + " is eating.");
	}
	
	// applying polymorphism concept
	// polymorphism is basically a method having same name with wih different parameters
	void walk(int steps) {
		System.out.println(name + " walked " + steps + " steps.");
	}
	
	
}

// by using extends keyword, Person class has been made as a
// parent class for Developer class
// so All the properties of Person class can be inherited by Developer class
class Developer extends Person{
	
	public Developer(int age, String name) {
		super(age, name);
	}
	
	// here this is an example of runtime polymorphism
	// because at run time object decide karega ki konsa walk function lena hai
	// Developer class ka walk() lena hai ya parent (Person) class me se lena hai
	
	// if walk() function present in developer class only then developer class me se hi walk() ko lelega
	// otherwise parent class me se lega ()
	void walk() {
		System.out.println("Developer " + name + " is walking.");
	}
}
