// Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.

// Example 1:

// Input: n = 3
// a = {1, 6, 2}
// Output: -1 1 1
// Explaination: There is no number at the 
// left of 1. Smaller number than 6 and 2 is 1.

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        if (n==1) return ans;
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        
        for(int i = 1;i<n;i++){
            boolean added = false;
            while(!st.isEmpty() && !added){
                if(st.peek()<arr[i]){
                    ans.add(st.peek());
                    
                    added = true;
                }
                else{
                    st.pop();
                }
            }
            if(st.isEmpty())ans.add(-1);
            st.push(arr[i]);
        }
        return ans;
    }
}
