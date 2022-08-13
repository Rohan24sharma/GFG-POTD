//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

// } Driver Code Ends


/*class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}*/

// {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
//  {5 24, 15 28, 27 40, 39 60, 50 90}



class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr,(a,b)->a.y-b.y);
        int ans = 1;
        int prev = arr[0].y;
        for(int i =0; i<n;i++){
            if(arr[i].x>prev){
                ans++;
                prev = arr[i].y;
            }
        }
        return ans;
       
    }
}
