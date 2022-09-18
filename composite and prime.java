// Given two integers L and R find the difference of number of composites and primes between the range L and R (both inclusive).

// Example 1:

// Input: L = 4, R = 6
// Output: 1
// Explanation: Composite no. are 4 and 6.
// And prime is 5.

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
            String[] S = br.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.Count(L, R);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int Count(int L, int R)
    {
        int prm = 0;
        int com = 0;
        for(int i = L;i<=R;i++){
            if(i!=1 && isPrime(i)){
                prm++;
            }
            else if (i!=1){
                com++;
            }
        }
        return  (com-prm);
    }
    static boolean isPrime(int n)
    {
 
        
        if (n <= 1)
            return false;
 
       
        else if (n == 2)
            return true;
 
        
        else if (n % 2 == 0)
            return false;
 
        
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
