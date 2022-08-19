// Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
// Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

// Example 1:

// Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
// Output: 5
// Explanation: The grid is-
// 1 1 1 0
// 0 0 1 0
// 0 0 0 1
// The largest region of 1's is colored
// in orange.



//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int ans = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ans = Math.max(ans,dfs(grid,i,j,vis));
                }
            }
        }
        return ans;
    }
    
    public int dfs(int[][] grid,int i,int j, boolean[][] vis){
        if(!valid(grid,i,j,vis))return 0;
        vis[i][j] = true;
        int ans = 1;
        ans+=dfs(grid,i+1,j,vis);
        ans+=dfs(grid,i-1,j,vis);
        ans+=dfs(grid,i,j+1,vis);
        ans+=dfs(grid,i,j-1,vis);
        ans+=dfs(grid,i+1,j+1,vis);
        ans+=dfs(grid,i+1,j-1,vis);
        ans+=dfs(grid,i-1,j+1,vis);
        ans+=dfs(grid,i-1,j-1,vis);
        return ans;
        
    }
    
    boolean valid(int[][] grid,int i, int j, boolean[][] vis){
        if(i<0 || j<0 || i == grid.length || j==grid[0].length || grid[i][j] == 0 || vis[i][j])return false;
        return true;
    }
    
    // boolean valid(int[][]grid,int i,int j,boolean[][]vis){
    //     if(i<0 || j<0 || i==grid.length || j==grid[0].length
    //     || grid[i][j]==0 || vis[i][j])return false;
    //     return true;
    // }
    
    
    
    
}
