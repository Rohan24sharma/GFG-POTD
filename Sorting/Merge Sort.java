//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] l1 = new int[n1];
        int[] r1 = new int[n2];
        for(int i =0;i<n1;i++)l1[i] = arr[i+l];
        for(int j =0;j<n2;j++)r1[j] = arr[m+j+1];
        int i =0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(l1[i] < r1[j]){
                arr[k] = l1[i];
                i++;
            }
            else{
                arr[k] = r1[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = l1[i];
            i++;
            k++;
        }
        
        while(j<n2){
            arr[k] = r1[j];
            j++;
            k++;
        }
    }
    
    
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r){
            int m = l+(r-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
        
    }
}
