//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] Arr = new int[N];
            for (int i = 0; i < N; ++i){
                Arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.minSubset(Arr,N);
            System.out.println(ans);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    int minSubset(int[] arr,int n) { 
        Arrays.sort(arr);
        if(n==1)return 1;
        long[] sum = new long[n];
        sum[0] = arr[0];
        for(int i = 1;i<n;i++){
            sum[i] = sum[i-1]+arr[i];
        }
        int j = n-2;
        while((sum[n-1]-sum[j])<=sum[j]){
            j--;
        }
        return (n-1-j);
        // ArrayList<Integer> ans = new ArrayList<>();
        // int s = arr[j];
        // ans.add(arr[j]);
        // while(s<=sum[j-1] && j>=0){
        //     j--;
        //     s+=arr[j];
        //     ans.add(arr[j]);
        // }
        // return ans.size();
    }
}
