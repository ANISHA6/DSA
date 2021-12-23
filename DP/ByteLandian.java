public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        
        if(n==0 || n==1)/// (n<=1)
            return n;
        if(memo.containsKey(n)) // if(memo.get(n)!=null)
            return memo.get(n);
        long max=Math.max(n,(bytelandian(n/2,memo)+bytelandian(n/3,memo)+bytelandian(n/4,memo)));
       // if(n<10000)
            memo.put(n,max);
        return max;
}
// Byteland has a very strange monetary system.
// Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4.
//But these numbers are all rounded down (the banks have to make a profit).
// You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
// You have one gold coin. What is the maximum amount of American dollars you can get for it?


// Sample Input  :2
// Sample Output  :2
// Explanation of Sample Output :
// If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them. 
//   It is better just to change the 2 coin directly into $2.
