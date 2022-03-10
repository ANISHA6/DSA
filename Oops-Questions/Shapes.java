import java.io.*;
import java.util.*;
class Shapes{
    int lsa;
    int tsa;
    int volume;
    void prints(int lsa, int tsa, int volume)
    {
        System.out.print(lsa+" "+tsa+" "+volume);
    }
}
class sphere extends Shapes{
    int r;
    sphere(int r){
        this.r=r;
    }
    void print(){
       int lsa=4*3*r*r;
       int tsa=lsa;
       int volume=4*r*r*r;
       prints(lsa, tsa, volume);
    }
    
}
class cylinder extends Shapes{
        int r,h;
    cylinder(int r, int h){
        this.r=r;
        this.h=h;
    }
    void print(){
        int lsa=2*3*r*h;
       int tsa=2*3*r*(r+h);
       int volume=3*r*r*h;
       prints(lsa, tsa, volume);
    }
}
class cube extends Shapes{
        int s;
    cube(int s){
        this.s=s;
    }
    void print(){
        int lsa=4*s*s;
       int tsa=6*s*s;
       int volume=s*s*s;
      prints(lsa, tsa, volume);
    }
    
}
public class Solution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		    if(x==1)
		    {
		        int r=s.nextInt();
		        sphere sp=new sphere(r);
		        sp.print();
		        
		    }
		    else if(x==2) 
		    {
		        int r=s.nextInt();
		        int h=s.nextInt();
		        cylinder c=new cylinder(r,h);
		        c.print();
		    }
		    else
		    {
		        int r=s.nextInt();
		        cube c=new cube(r);
		        c.print();
		    }
		
	}
}
