// A board of length M and width N is given. The task is to break this board into M * N squares such that cost of breaking is minimum. The cutting cost for each edge will be given for the board in two arrays X[] and Y[]. In short, you need to choose such a sequence of cutting such that cost is minimized. Return the minimized cost.

// Example 1:

// Input:
// M = 6. N = 4
// X[] = {2, 1, 3, 1, 4}
// Y[] = {4, 1, 2}
// Output: 42
// Explanation: 

// For above board optimal way to cut into square is:
// Total minimum cost in above case is 42. It is 
// evaluated using following steps.
// Initial Value : Total_cost = 0
// Total_cost = Total_cost + edge_cost * total_pieces
// Cost 4 Horizontal cut:      Cost = 0 + 4*1 = 4
// Cost 4 Vertical cut:        Cost = 4 + 4*2 = 12
// Cost 3 Vertical cut:        Cost = 12 + 3*2 = 18
// Cost 2 Horizontal cut:      Cost = 18 + 2*3 = 24
// Cost 2 Vertical cut:        Cost = 24 + 2*3 = 30
// Cost 1 Horizontal cut:      Cost = 30 + 1*4 = 34
// Cost 1 Vertical cut:        Cost = 34 + 1*4 = 38
// Cost 1 Vertical cut:        Cost = 38 + 1*4 = 42

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
        Scanner sc=new Scanner(System.in);
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String P[]=br.readLine().trim().split(" ");
            int m=Integer.parseInt(P[0])-1;
            int n=Integer.parseInt(P[1])-1;
            String A[]=br.readLine().trim().split(" ");
            String B[]=br.readLine().trim().split(" ");
            ArrayList<Integer> l=new ArrayList<>();
            for(String s : A){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            for(String s : B){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            int [] X =new int[m];
            int [] Y=new int[n];
            int ind=0;
            for(int i=0;i<m;i++){
                X[i]=l.get(ind++);
            }
            for(int i=0;i<n;i++){
                Y[i]=l.get(ind++);
            }
            
            Solution obj = new Solution();
            int res = obj.minimumCostOfBreaking(X, Y,m,n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        Arrays.sort(X);
        Arrays.sort(Y);
        int i = X.length-1;
        int j = Y.length-1;
        int rows = 1;
        int cols = 1;
        int ans = 0;
        while(i>=0 || j>=0){
            int a=i>=0?X[i]:-1;
            int b=j>=0?Y[j]:-1;
            if(a>=b){
                ans+=(a*rows);
                cols++;
                i--;
            }
            else{
                ans+=(b*cols);
                rows++;
                j--;
            }
        }
        return ans;
        
    }
}
