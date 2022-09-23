// Geek has a string Sof size Nconsisting of characters from '0'to '9'. He wants to minimise the length of the string. In each minimising operation, geek can remove any two consecutive characters if they are of the form {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"}.
// Find the minimum possible length of the string after applying minimising operations. 
 

// Example 1:

// Input: 
// N = 5 
// S = "12213"
// Output: 1
// Explanation: Geek can get the string of 
// length 1 in two minimising operation,
// In 1st operation Geek will remove "12" 
// from "12213" then Geek left with "213"
// In 2nd operation Geek will remove "21" 
// from "213" then Geek left with "3"

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s, n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public int minLength(String s, int n) { 
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	int[] pairs = new int[]{9,2,1,4,3,6,5,8,7,0};
    	for(char ch:s.toCharArray()){
    	    int k = ch-'0';
    	    if(st.size() == 0){
    	        st.push(k);
    	    }else{
    	        if(st.peek() == pairs[k]){
    	            st.pop();
    	        }
    	        else{
    	            st.push(k);
    	        }
    	    }
    	}
    	return st.size();
    	
    	
    }
}
