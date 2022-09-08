// You are given two arrays A and B of unique elements of size N. Check if one array is a stack permutation of the other array or not.
// Stack permutation means that one array can be created from another array using a stack and stack operations.

 

// Example 1:

// Input:
// N = 3
// A = {1,2,3}
// B = {2,1,3}
// Output:
// 1
// Explanation:
// 1. push 1 from A to stack
// 2. push 2 from A to stack
// 3. pop 2 from stack to B
// 4. pop 1 from stack to B
// 5. push 3 from A to stack
// 6. pop 3 from stack to B

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.isStackPermutation(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
       // code here
       Stack<Integer> stack=new Stack<>();
       ArrayList<Integer> res=new ArrayList<>();
       int k=0,x=0;
       for(int i=0;i<n;i++)
       {
           if(ip[i]==op[k])
           {
               res.add(ip[i]);
               k++;
               while(!stack.isEmpty())
               {
                   if(stack.peek()==op[k])
                   {
                       res.add(stack.pop());
                       k++;
                   }
                   else{
                       break;
                   }
               }
           }
           else{
               stack.push(ip[i]);
               }
           
       }
       
       if(res.size()!=op.length)
       {
           return 0;
       }
       
       for(int i:res)
       {
           if(i!=op[x])
           {
               return 0;
           }
           x++;
       }
       return 1;
   }
}
