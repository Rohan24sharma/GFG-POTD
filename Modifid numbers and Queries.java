// Find the sum of all the numbers between the range l and r. Here each number is represented by the sum of its prime factors. 
// Note : For example, 6 is represented by 5 because 6 has two prime factors 2 and 3 and 2 + 3 = 5.

// Example 1:

// Input: l = 1, r = 2
// Output: 3
// Explanation: 1->1, 2->2 and 1+2=3.  

// Example 2:

// Input: l = 1, r = 6
// Output: 18
// Explanation: 1->1, 2->2, 3->3, 4->2
// 5->5, 6->2+3=5, 1+2+3+2+5+5 = 18. 


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
            int l = Integer.parseInt(input[0]); 
            int r = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.sumOfAll(l,r));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int sumOfAll(int l, int r)
    {
        ArrayList<Integer> st = new ArrayList<>();
        if(l==1)st.add(1);
        for(int i = l;i<=r;i++){
            st.addAll(primeFactors(i));
        }
        
        int sum = 0;
        for(int i=0;i<st.size();i++){
            sum += st.get(i);
        }
        return sum;
    }
    
    public static ArrayList<Integer> primeFactors(int n)
    {
        Set<Integer> set = new HashSet<Integer>();
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                set.add(c);
                n /= c;
            }
            else
                c++;
        }
        ArrayList<Integer> ans = new ArrayList<>(set);
        return ans;
        
    }
}
