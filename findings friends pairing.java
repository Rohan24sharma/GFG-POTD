//{ Driver Code Starts
//Initial Template for Java

//Given N friends, each one can remain single or can be paired up with some other friend.
//Each friend can be paired only once.
//Find out the total number of ways in which friends can remain single or can be paired up.
//Note: Since answer can be very large, return your answer mod 10^9+7.

// Input:N = 3
// Output: 4
// Explanation:
// {1}, {2}, {3} : All single
// {1}, {2,3} : 2 and 3 paired but 1 is single.
// {1,2}, {3} : 1 and 2 are paired but 3 is single.
// {1,3}, {2} : 1 and 3 are paired but 2 is single.
// Note that {1,2} and {2,1} are considered same.


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       if(n<=2)return n;
       long mod = (int)Math.pow(10,9)+7;
       long secondPrev = 1;
       long prev = 2;
       long curr = 0;
       for(int i =3;i<=n;i++){
           curr = (prev+(((i-1)%mod)*(secondPrev%mod))%mod)%mod;
           secondPrev = prev;
           prev = curr;
       }
       return curr;
    }
}    
 
