// Write a program that receives a number n as input and prints it in the following format as shown below.
// Like for n = 2 the pattern will be:
// 1*2*5*6
// --3*4

// Example 1:

// Input: n = 3
// Output: 
// 1*2*3*10*11*12
// --4*5*8*9
// ----6*7
// Explaination: If the pattern shown in question 
// is followed, this will be the output.

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<String> ans = ob.pattern(n);
            for(int i = 0;i < n;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> pattern(int n){
        // code here
        List<String> result = new ArrayList<>();
        int ptr1 = 1;
        int ptr2 = n*n + 1;
        int temp = n;
        String addFront = "--";
        while (temp > 0) {
            String letter = "";
            if (temp != n) {
                letter += addFront;
                addFront += "--";
            }
            for (int i=1; i<=temp; i++, ptr1++) {
                letter += ptr1;
                if (i != temp)
                    letter += "*";
            }
            letter += "*";
            for (int i=1; i<=temp; i++, ptr2++) {
                letter += ptr2;
                if (i != temp)
                    letter += "*";
            }
            ptr2 -= 2*temp-1;
            temp--;
            result.add(letter);
        }
        return result;
    }
}
