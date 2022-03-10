public class Player{
    String p_name;
    int jnumber, t_runs, innings, notouts;
    int avg;
    // complete the functions below to print the output in desired format
    void set(String name,int number,int runs,int inn,int nos){
        this.p_name=name;
        this.jnumber=number;
        this.t_runs=runs;
        this.innings=inn;
        this.notouts=nos;
        int out=inn-nos;
        findavg(runs, out);
        
    }
    void findavg(int runs, int out){
        this.avg=runs/out;
    }
    void print(){
        System.out.println(this.p_name+" "+jnumber+" "+t_runs+" "+innings+" "+notouts+" "+avg);
    }
    
    
}
