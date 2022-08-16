// A(X) for positive integer X is the sum of factorials of its digits. For example, A(154) = 1! + 5! + 4!= 145.
// Given a number N, find the minimum number X such that A(X) = N. You have to return a list of digits which represent the number X.

// Example 1:

// Input: N = 40321
// Output: 18
// Explanation: A(18)=1!+ 8! =40321 
// Note that A(80) and A(81) are also 
// 40321, But 18 is the smallest 
// number.


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
            String s = br.readLine().trim();
            int N = Integer.parseInt(s);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.FactDigit(N);
            for (Integer val: ans) 
                System.out.print(val);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> FactDigit(int N)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] fact = new int[10];
        for(int i =1;i<=9;i++){
            fact[i] = factorial(i);
        }
        for(int i =9;i>0;i--){
            while(N>=fact[i]){
                N = N-fact[i];
                ans.add(i); 
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    
    static int factorial(int n){
        if(n==1)return 1;
        return n*factorial(n-1);
    }
}
