// Find the number of occurrences of a given search word in  a 2d-Array of characters where the word can go up, down, left, right and around 90 degree bends.


// Example 1:

// Input: 
// R = 4, C = 5
// mat = {{S,N,B,S,N},
//        {B,A,K,E,A},
//        {B,K,B,B,K},
//        {S,E,B,S,E}}
// target = SNAKES
// Output:
// 3
// Explanation: 
// S N B S N
// B A K E A
// B K B B K
// S E B S E
// Total occurrence of the word is 3
// and denoted by color.

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int ans;
    public int findOccurrence(char mat[][], String target)
    {
        ans = 0;
        for(int i =0; i<mat.length;i++){
            for(int j = 0; j<mat[0].length;j++){
                dfs(mat,i,j,target,0);
            }
        }
        return ans;
        
    }
    void dfs(char[][] mat, int i,int j,String target,int idx){
        if(i<0 || j<0 || i==mat.length || j==mat[0].length || idx>=target.length() 
        || target.charAt(idx) != mat[i][j]){
            return;
        }
        if(idx == target.length()-1){
            ans++;
            return;
        }
        char c = mat[i][j];
        mat[i][j] = '0';
        dfs(mat,i+1,j,target,idx+1);
        dfs(mat,i-1,j,target,idx+1);
        dfs(mat,i,j+1,target,idx+1);
        dfs(mat,i,j-1,target,idx+1);
        mat[i][j] = c;
    }
}
