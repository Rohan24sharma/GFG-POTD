// Given a number N, you need to find if its digital root is prime or not. DigitalRoot of a number is the repetitive sum of its digits until we get a single-digit number.
// Eg.DigitalRoot(191)=1+9+1=>11=>1+1=>2

// Example 1:

// Input:
// N = 89
// Output:
// 0
// Explanation:
// DigitalRoot(89)=>17=>1+7=>8; not a prime.


//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            
            Solution ob = new Solution();
            int ans  = ob.digitalRoot(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int digitalRoot(int N){
        // code here
        int sum = sumOfDigits(N);
        while(sum/10 != 0){
            sum = sumOfDigits(sum);
        }
        return isPrime(sum);
    }
    
    
    static int sumOfDigits(int n){
        int ans = 0;
        while(n>0){
            ans += n%10;
            n = n/10;
        }
        return ans;
    }
    
     static int isPrime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return 0;
 
        // Check if number is 2
        else if (n == 2)
            return 1;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return 0;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return 0;
        }
        return 1;
    }
}
