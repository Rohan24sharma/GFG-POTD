// Given a array of N strings, find the longest common prefix among all strings present in the array.


// Example 1:

// Input:
// N = 4
// arr[] = {geeksforgeeks, geeks, geek,
//          geezer}
// Output: gee
// Explanation: "gee" is the longest common
// prefix in all the given strings.

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends

// a = geek



//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        if(arr.length == 1)return arr[0];
        int m = arr[0].length();
        String a = arr[0];
        for(int i =0;i<n;i++)
        {
            if(arr[i].length() < m)
            {
                a = arr[i];
                m = arr[i].length();
            }
        }
        int ind = a.length();
        int i =0;
        while(ind>0 && i<n)
        {
            if(arr[i].substring(0,ind).contains(a))
            {
                i++;
            }
            else
            {
                ind--;
                a = a.substring(0,ind);
            }
        }
        if(ind==0) return "-1";
        return a.substring(0,ind);
    }
        
}
