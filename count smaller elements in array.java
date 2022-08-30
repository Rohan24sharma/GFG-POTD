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

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {

   int[] constructLowerArray(int[] arr, int n) {
       int[] sol = new int[n];
       n--;
       sol[n] = 0;
       Node root=new Node(0,arr[n]);        
       while(n-->0){
           sol[n]=filling(arr,n,root);
       }
       return sol;
   }
   int filling(int[] arr, int n, Node root){
       if(arr[n]<=root.key){
           root.data=root.data+1;
           if(root.left==null){
               root.left=new Node(0,arr[n]);
               return 0;
           }
           return filling(arr,n,root.left);
       }
       if(arr[n]>root.key){
           if(root.right==null){
               root.right=new Node(0,arr[n]);
               return root.data+1;
           }
           return root.data+1+filling(arr,n,root.right);
       }
       return -3645;
   }
}
class Node{
   int data;
   int key;
   Node left;
   Node right;
   Node(int data, int key){
       this.data=data;
       this.key=key;
       left=null;
       right=null;
   }
}
