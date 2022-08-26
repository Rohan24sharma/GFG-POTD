// Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) which could be formed from the string str.
// Note: You have to return the answer module 109+7;
 

// Example 1:

// Input: 
// Str = "abcd"
// Output: 
// 4
// Explanation:
// palindromic subsequence are : "a" ,"b", "c" ,"d"
 

// Example 2:

// Input: 
// Str = "aab"
// Output: 
// 4
// Explanation:
// palindromic subsequence are :"a", "a", "b", "aa"
 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function countPs() which takes a string str as input parameter and returns the number of palindromic subsequence.
 

// Expected Time Complexity: O(N*N)
// Expected Auxiliary Space: O(N*N)


//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

// i =0 
//      j = 0   j=1     j=2     j=3
//      a       ab      abc     abcd
// count 1
// i = 1
//      j = 1   j=2     j=3
//      b       bc      bcd


class Solution
{
    long countPS(String str)
    {
        int mod = 1000000007;
        int count = 0;
        for(int i =0;i<str.length();i++){
            for(int j = i;j<str.length();j++){
                String a = revString(str.substring(i,j+1));
                if(isPalindrome(str.substring(i,j+1),a))count++;
            }
        }
        return count;
    }
    
    boolean isPalindrome(String s,String a){
        if(s.length() != a.length())return false;
        else{
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)!= a.charAt(i))return false;
            }
        }
        return true;
        
    }
    
    String revString(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
} 

// using dynamic programming



//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long ans;
    long dp[][];
    long mod = 1000000007;
    long countPS(String str)
    {
        ans = 0;
        dp = new long[str.length()][str.length()];
        return dfs(str,0,str.length()-1);
    }
    long dfs(String s, int i, int j){
        if(i==j)return 1;
        
        if(i+1 == j)return s.charAt(i)==s.charAt(j)?3:2;
        if(dp[i][j] != 0)return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = (1+dfs(s,i,j-1)+dfs(s,i+1,j))%mod;
        }
        else{
            dp[i][j] = (dfs(s,i+1,j)+dfs(s,i,j-1))%mod; 
            dp[i][j] = (dp[i][j] - dfs(s,i+1,j-1)+mod)%mod;
            return dp[i][j];
        }
    }
}


