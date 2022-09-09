// Find the smallest number such that the sum of its digits is N and it is divisible by 10N.

// Example 1:

// Input: N = 5
// Outptut: 500000
// Explanation: Sum of digits of 500000
// is 5 and divisible by 105

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.digitsNum(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String digitsNum(int N)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(sumOfDigits(N));
        for(int i = 0;i<N;i++){
            sb.append("0");
        }
        return sb.toString();
    }
    String sumOfDigits( int n){
        StringBuilder sc = new StringBuilder();
        while(n>9){
            sc.append("9");
            n = n-9;
        }
        if(n<=9){
            sc.append(Integer.toString(n));
        }
        String ans = sc.reverse().toString();
        return ans;
    }
}
