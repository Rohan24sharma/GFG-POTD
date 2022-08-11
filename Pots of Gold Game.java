//{ Driver Code Starts
import java.util.*;
import java.lang.Math;
class Pots{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] a =new  int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			GfG g = new GfG();
			System.out.println(g.maxCoins(a,n));
			
		}
	}
}
// } Driver Code Ends

/*Complete the function below*/
class GfG
{
	public static int maxCoins(int A[],int n)
	{
	    int [][] dp = new int[n+1][n+1];
	    return maxi(A, 0, n-1,dp);
	        
    }
    
    static int maxi(int arr[], int i, int j, int[][] dp){
        //int dp[] = new int[n];
        if(i==j)return arr[i];
        if(i+1 == j)return Math.max(arr[i],arr[j]);
        if(dp[i][j] != 0) return dp[i][j];
        int counti = arr[i]+ Math.min(maxi(arr,i+2,j,dp),maxi(arr,i+1,j-1,dp));
        int countn = arr[j]+ Math.min(maxi(arr,i+1,j-1,dp),maxi(arr,i,j-2,dp));
        return dp[i][j] =  Math.max(counti, countn);
    }
    
}
