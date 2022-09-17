// A flock of sheep is running east along a straight, narrow road. Each one is running at its own constant speed. Whenever a sheep catches up to the one in front of it, it has to slow down and follow at the speed of the other sheep. You are in a mobile crane behind the flock, chasing the sheep towards the barn at the end of the road. The arm of the crane allows you to pick up any sheep momentarily, let the sheep behind it pass underneath, and place the picked-up sheep back down. This operation takes no time and can only be performed on a pair of sheep that are immediately next to each other, even if 3 or more sheep are in a row, one after the other.

// Given the initial locations (Xi) at time 0 and natural speeds (Vi) of the sheep, as well as the location of the barn (B), what is the minimum number of swaps you need to perform with your crane in order to have at least K of the N sheep arrive at the barn no later than time T?

// You may think of the sheep as points moving along a line. Even if 3 or more sheep are at the same location, next to each other, picking up one of them will only let one of the other two pass through. Any swap is instantaneous, which means that you may perform multiple swaps at the same time, but each one will count as a separate swap.

// Example 1:

// Input:
// N=5
// k=3
// B=10
// T=5
// POS[]={0,2,5 ,6, 7}
// V[]={1,1,1,1,4}
// Output:
// 0
// Explanation:
// Sheep 5,4 and 3 will reach the barn before or at 5 secs.

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
            
            int[] a = IntArray.input(br, 4);
            int n = a[0],k=a[1],b=a[2],T=a[3];
            
            int[] c = IntArray.input(br, a[0]);
            
            
            int[] v = IntArray.input(br, a[0]);
            
            Solution obj = new Solution();
            int res = obj.minimumSwaps(c, v,n,k,b,T);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSwaps(int[] c, int[] v,int n,int k,int b,int t) {
        int ts = 0;
        int sl = 0;
        for(int i = n-1;i>=0;i--){
            if((c[i]+(v[i]*t))>=b){
                k--;
                ts += sl;
                if(k==0)return ts;
            }
            else{
                sl++;
            }
        }
        return -1;
    }
}
        
