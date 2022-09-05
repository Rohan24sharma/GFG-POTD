// You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

// Example 1:

// Input:
// N = 5
// arr[] = {1,2,3,4,5}
// Output: 6
// Explanation: Smallest positive missing 
// number is 6.

//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        int ans = -1;
        int max = -1;
        for(int i = 0;i<size;i++){
            max = Math.max(max,arr[i]);
        }
        boolean[] hs = new boolean[max+1];
        hs[0]=true;
        for(int i = 0;i<size;i++){
            if(arr[i]>=0){
                hs[arr[i]] = true;
            }
        }
        for(int i = 0;i<hs.length;i++){
            if(hs[i]==false){
                ans = i;
                break;
            }
        }
        return ans==-1?max+1:ans;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends
