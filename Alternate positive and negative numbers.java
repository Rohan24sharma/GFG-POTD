//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
// -5 -2 5 2 4 7 1 8 0 -8
// pos = 5 2 4 7 1 8 0    7
// neg = -5 -3 -8         3
// k ==  0  1 2  3 4  5 6  7 8 9 
//ans  = 5 -5 2 -3 4 -8 7  1 8 0 
// i = 7
// j = 3


class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(arr[i]>=0) pos.add(arr[i]);
            if(arr[i]<0) neg.add(arr[i]);
        }

        
        int ans[] = new int[n];
        int i = 0;
        int j=0;
        int k=0;
        while(i<pos.size() || j<neg.size()){
            if(i<pos.size()){
                ans[k] = pos.get(i);
                i++;
                k++;
            }
            if(j<neg.size()){
                ans[k] = neg.get(j);
                j++;
                k++;
            }
        }
        for( i=0; i<n; i++){
           arr[i] = ans[i];
            
        }
    }
}
