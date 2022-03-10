package oops;

public class RunTimePolymorphism {

	public static void main(String[] args) {
		System.out.println("Hello Sunshine");
		
		
		Student s = new Student("Paritosh", 22);
		// this is an example of compile time polymorphism because at a compile time we can decide ki kon sa walk function use hoga.
		s.walk();
		s.walk(5);
		
		
		Teacher t = new Teacher("Harsh", 28);
		t.walk(); 	// runtime polymorphism because Person and Developer both have walk() function
					// so during the runtime, object d needs to decide which walk() function he will be accessing.
		
		// NOTE
		
		// if the child class has the required functions then object simply access the object which is their in its class only
		// other wise the object of the child class tries to find the needed function or variable from its parent's class
		
	}
}


class Student{
	String name;
	int age;
	
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void walk() {
		System.out.println(name + " is walking.");
	}
	
	
	void walk(int steps) {
		System.out.println(name + " has walked " + steps + " steps");
	}
	
	void eat() {
		System.out.print(name + " is eating.");
	}
	
}

class Teacher extends Student{
	public Teacher(String name, int age) {
		super(name, age);
	}

	void walk() {
		System.out.println("Developer " + name + " is walking.");
	}
	
	
}
