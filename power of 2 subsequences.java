//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            ArrayList<Long> A = new ArrayList<Long>();
            String in[] = read.readLine().trim().split(" ");
            for(var i : in){
                Long x = Long.parseLong(i);
                A.add(x);
            }

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(N,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        int count = 0;
        int mod = 1000000007;
        for(Long i:A){
            if((i&(i-1)) == 0)count++;
        }
        return (long)(Math.pow(2,count)%mod-1)%mod;
    }
}
