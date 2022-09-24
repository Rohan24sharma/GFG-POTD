// Two players, Player 1 and Player 2, are given an integer N to play a game. The rules of the game are as follows :
// 1. In one turn, a player can remove any set bit of N in its binary representation to make a new N.
// 2. Player 1 always takes first turn.
// 3. If a player cannot make a move, he loses.
// Assume that both the players play optimally.

 

// Example 1:

// Input:
// N = 8
// Output:
// 1
// Explanation:
// N = 8
// N = 1000 (binary)
// Player 1 takes the bit.
// The remaining bits are all zero.
// Player 2 cannot make a move, 
// so Player 1 wins.

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            int res = obj.swapBitGame(N);
            
            System.out.println(res);
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int swapBitGame(long N) {
        // code here
        String s = java.lang.Long.toBinaryString(N);
        int setBits = 0;
        for(char i:s.toCharArray()){
            if(i == '1')setBits++;
        }
        if(setBits%2 == 0)return 2;
        return 1;
        
    }
}
