// Given an array arr[] and an integer K where K is smaller than size of array, 
// the task is to find the Kth smallest element in the given array. 
// It is given that all array elements are distinct.

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        int n = arr.length;
        countSort(arr,n);
        return arr[k-1];
        
    }
    
    static int maxii(int[] arr, int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    
    
    // count sort O(n+k)
    
    static void countSort(int arr[], int n){
        int max = maxii(arr,n);
        
        int[] hash = new int[max+1];
        
        for(int i =0;i<n;i++){
            hash[arr[i]]++;
        }
        
        int ind = 0;
        for (int i = 0; i < max+1; i++) {
            int count = hash[i];
            while (count > 0) {
                arr[ind++] = i;
                count --;
            }
        }
    }
}



// using priority queue


//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        for(int i= 0;i<n;i++){
            pq.add(arr[i]);
        }
        for(int i =1;i<k;i++){
            pq.poll();
        }
        return pq.peek();
    } 
}

