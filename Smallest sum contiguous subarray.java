// Given an array arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the minimum sum and return its sum.

// Example 1:

// Input: 
// arr[] = {3,-4, 2,-3,-1, 7,-5}
// Output: -6
// Explanation: sub-array which has smallest 
// sum among all the sub-array is {-4,2,-3,-1} = -6

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        int cur_sum = 0;
        int min_sum = a[0];
        for(int i = 0;i<size;i++){
            cur_sum +=a[i];
            if(cur_sum<min_sum){
                min_sum = cur_sum;
            }
            if(cur_sum>0){
                cur_sum = 0;
            }
        }
        return min_sum;
    }
}
