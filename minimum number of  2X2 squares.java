// Given the base (in units) of a right-angled isoceles traingle, find the maximum number of 2X2 squares that can fit in the triangle with given base.

// Example 1:

// Input: 8
// Output: 6
// Explanation:
// Please refer below diagram for explanation.
// squares-in-triangle


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());//testcases
        
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());//input n
            
            Solution ob= new Solution();
            System.out.println(ob.numberOfSquares(n));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long numberOfSquares(long base)
    {
        //code here
        long n = (base/2)-1;
        long ans = n*(n+1)/2;
        return ans;
    }
}
