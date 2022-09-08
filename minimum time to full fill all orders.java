// Geek is organizing a party at his house. For the party, he needs exactly N donuts for the guests. Geek decides to order the donuts from a nearby restaurant, which has L chefs and each chef has a rank R. 
// A chef with rank R can make 1 donut in the first R minutes, 1 more donut in the next 2R minutes, 1 more donut in 3R minutes, and so on.
// For example. a chef with rank 2, can make one donut in 2 minutes, one more donut in the next 4 minutes, and one more in the next 6 minutes. So, it take 2 + 4 + 6 = 12 minutes to make 3 donuts. A chef can move on to making the next donut only after completing the previous one. All the chefs can work simultaneously.
// Since, it's time for the party, Geek wants to know the minimum time required in completing N donuts. Return an integer denoting the minimum time

// Example 1:

// Input:
// N = 10
// L = 4
// rank[] = {1, 2, 3, 4}
// Output: 12
// Explanation: 
// Chef with rank 1, can make 4 donuts in time 1 + 2 + 3 + 4 = 10 mins
// Chef with rank 2, can make 3 donuts in time 2 + 4 + 6 = 12 mins
// Chef with rank 3, can make 2 donuts in time 3 + 6 = 9 mins
// Chef with rank 4, can make 1 donuts in time = 4 minutes
// Total donuts = 4 + 3 + 2 + 1 = 10 and total time = 12 minutes.


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
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int l; 
            l = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, l);
            
            Solution obj = new Solution();
            int res = obj.findMinTime(n, l, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int donutCount(int min,int rank[])
    {
        int dCount = 0;
        for(int i = 0;i < rank.length;i++)
        {
            int chefRank = rank[i];
            if(chefRank > min) continue;
            int curDount = 1;
            int curTime = chefRank;
            
            while(curTime <= min)
            {
                dCount++;
                curDount++;
                curTime += curDount*chefRank;
            }
        }
        return dCount;
    }
    public static int findMinTime(int n, int arrLength, int[] arr) {
        int l = 1, h = 10000000;
        while(l <= h)
        {
            int mid = (l+h)/2;
            int midRes = donutCount(mid,arr);
            if(n <= midRes) h = mid-1;
            else l = mid+1;
        }
        return l;
    }
}
