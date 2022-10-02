// Given string str of length N. The task is to find the minimum characters to be added at the front to make string palindrome.
// Note: A palindrome is a word which reads the same backward as forward. Example: "madam".

// Example 1:

// Input:
// S = "abc"
// Output: 2
// Explanation: 
// Add 'b' and 'c' at front of above string to make it
// palindrome : "cbabc"

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static int minChar(String str) {
        int n = str.length();
        int i = 0;
        int j = n-1;
        int ans = n-1;
        while(i<j){
            if(str.charAt(i) == str.charAt(j)){
                i+=1;
                j-=1;
            }
            else{
                i=0;
                ans -=1;
                j = ans;
            }
        }
        return n - ans -1;
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}
// } Driver Code Ends
