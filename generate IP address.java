// Generate IP Addresses
// EasyAccuracy: 43.42%Submissions: 21083Points: 2
// Lamp
// This problem is part of GFG SDE Sheet. Click here to view more.  

// Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing all possible combinations of valid IPv4 IP addresses and takes only a string S as its only argument.
// Note: Order doesn't matter. A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.


// For string 11211 the IP address possible are 
// 1.1.2.11
// 1.1.21.1
// 1.12.1.1
// 11.2.1.1

// Example 1:

// Input:
// S = 1111
// Output: 1.1.1.1

//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/


class Solution {
    public ArrayList<String> genIp(String s) {
        
        ArrayList<String> ans = new ArrayList<String>();
        int n = s.length();
        if(n>12){
            ans.add("-1");
        }
        for(int i = 0;i<=n-2;i++){
            for(int j =i+1;j<n-1;j++){
                for(int k = j+1;k<n;k++){
                    String a = s.substring(0,i);
                    String b = s.substring(i,j);
                    String c = s.substring(j,k);
                    String d = s.substring(k,n);
                    if(validx(a) && validx(b) && validx(c) && validx(d)){
                        ans.add(a+"."+b+"."+c+"."+d);
                    }
                }
            }
        }
        
        return ans;
    }
    
    boolean validx(String s){
        int n = s.length();
        if( n==0 || n>3 || (s.charAt(0) == '0' && n>1) || Integer.parseInt(s)>255)return false;
        return true;
    }
}
