
/* Signature of four required functions is given in the code. You can create other functions as well if you need.
*  Also you should submit your code even if you are not done with all the functions. 
*/

// Main used internally is shown here just for your reference.
/*public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int degree1[] = new int[n];
		for(int i = 0; i < n; i++){
			degree1[i] = s.nextInt();
		}
		int coeff1[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff1[i] = s.nextInt();
		}
		Polynomial first = new Polynomial();
		for(int i = 0; i < n; i++){
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		n = s.nextInt();
		int degree2[] = new int[n];
		for(int i = 0; i < n; i++){
			degree2[i] = s.nextInt();
		}
		 int coeff2[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff2[i] = s.nextInt();
		}
		Polynomial second = new Polynomial();
		for(int i = 0; i < n; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		int choice = s.nextInt();
		Polynomial result;
		switch(choice){
		// Add
		case 1: 
			 result = first.add(second);
			result.print();
			break;
		// Subtract	
		case 2 :
			 result = first.subtract(second);
			result.print();
			break;
		// Multiply
		case 3 :
			 result = first.multiply(second);
			result.print();
			break;
		}

	}
  */


public class Polynomial {

	
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
   private int[] data;
    public Polynomial(){
        data=new int[100];
      //  private int index=0;
        
        
    }

	public void setCoefficient(int degree, int coeff){
       // data[degree]+=coeff;
        if(degree>=data.length){
            doubleCapacity(degree);
        }
        
        data[degree]=coeff;
        
}
    public void doubleCapacity(int deg){
        int temp[]=data;
        data=new int[1+deg];
        for(int i=0;i<data.length;i++){
            data[i]=temp[i];
        }
    }
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
        
        for(int i =0 ;i<data.length;i++){
			if(data[i]!=0){
				System.out.print(data[i]+"x"+i+" ");
			}
        }
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
        for(int i=0;i<this.data.length;i++){
			for(int j=0;j<p.data.length;j++){
				if(i==j && (this.data[i]!=0 || p.data[j]!=0)){
					this.data[i]+=p.data[j]; // hold the address of the object on which this add function has called
				}
			}
		}
        return this; // Here we are returning the address where we store the result.
        
        
        
       
        
		
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
        for(int i=0;i<this.data.length;i++){
			for(int j=0;j<p.data.length;j++){
				if(i==j && (this.data[i]!=0 || p.data[j]!=0)){
					this.data[i]-=p.data[j];
				}
			}
		}
        return this;
        
        
			
	}
    //create function for grtting the coefficient value
    public int getCoef(int deg){
        if(deg>=data.length){
            return 0;
        }
        return data[deg];
    }
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
        Polynomial ans =new Polynomial();

		for(int i=0;i<this.data.length/2;i++){
			for(int j=0;j<p.data.length/2;j+=1){

				// a.data[(i+j)]+=this.data[i]*p.data[j];
                int termdeg=i+j;
                int termcoef=this.data[i]*p.data[j];
                int oldcoef=ans.getCoef(termdeg);
                ans.setCoefficient(termdeg, termcoef+oldcoef);

			}
			
		}
		return ans;
        
		
	}

}
