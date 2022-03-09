/******************
 * Following is the main function we are using internally.
 * Refer this for completing the ComplexNumbers class
 * 
 
 public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = s.nextInt();
		 
		if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}
	}
 ******************/

public class ComplexNumbers {
    
	// Complete this class
  private int R;
   private int I;
    
    
    public ComplexNumbers(int R, int I){
        this.R=R;
        this.I=I;
        
    }
    public void plus(ComplexNumbers c2){//this.R refers R variable of current object on which this function was called
        this.R=this.R+c2.R;             //c2.R referes R variable of c2 object
        this.I=this.I+c2.I;
    }
    public void multiply(ComplexNumbers c2){
        int x=this.R;
        this.R=this.R*c2.R-(this.I*c2.I);
        this.I=(x*c2.I)+(this.I*c2.R);
    }
    public void print(){
        System.out.println(R + " "+"+" +" "+"i"+ I);
    }
	
}
