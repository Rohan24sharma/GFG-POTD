// The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints that from each cell you can either move only to right or down.

// Example 1:

// Input: m = 2, n = 2
// Output: 2 
// Explanation: Two possible ways are
// RD and DR.  

// Example 2:

// Input: m = 3, R = 3
// Output: 6
// Explanation: Six possible ways are
// RRDD, DDRR, RDDR, DRRD, RDRD, DRDR. 

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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    int x;
    int y;
    long mod = 1000000007;
    long numberOfPaths(int m, int n)
    {
        // code here
        x = m;
        y = n;
        long[][] dp = new long[x+1][y+1];
        return dfs(0,0,dp);
    }
    long dfs(int i, int j,long[][] dp){
        if(dp[i][j] != 0)return dp[i][j];
        if(i == x || j==y)return 0;
        if(i==x-1 || j==y-1)return 1;
        long right = dfs(i,j+1,dp);
        long down = dfs(i+1,j,dp);
        return dp[i][j] = (right+down)%mod;
    }
}
