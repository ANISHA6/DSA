public class Main {
    public static void columnName(int n){
        
        char[] str=new char[50];
        int i=0;
        while(n>0){
            int r=n%26;
            if(r==0){
                str[i++]='Z';
                n=n/26-1;// or, n=q-1
            }
            else{
                str[i++]=(char)(r-1+'A');
                n=n/26;
            }
        }
        str[i]='\0';
        i--;
        String ans="";
        for(;i>=0;i--){
            ans+=str[i];
        }
        System.out.println(ans);
    }

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        columnName(n);
        
         // Self
        String s="";
        while(n!=0){
            int q=n/26;
            int r=n-26*q; //n=26*q+r
            if(r==0){
                s=s+"z";
                n=q-1;
}
        
        else {
            s=s+(char)(r+65-1);
        
            n=q;
        }}
        String ans="";
       for(int i=0;i<s.length();i++){
           ans=s.charAt(i)+ans;
       }
        System.out.println(ans);

	}

}
