//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        char[] arr = str.toCharArray(); // convert string to character array
        Arrays.sort(arr);
        
        int upper = -1;
        int lower = -1;
        
        if(arr[0] < 97)upper = 0;       // upper pointer index
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>=97){
                lower = i;              // lower pointer index
                break;
            }
        }
        
        if(lower == -1 || upper == -1 )return new String(arr);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0;i<str.length();i++){
            
            if(str.charAt(i)>=97){
                sb.append(arr[lower]);
                lower++;
            }
            else{
                sb.append(arr[upper]);
                upper++;
            }
            
        }
        return sb.toString();
    }
}

//{ Driver Code Starts.

class GFG {
    
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}

// } Driver Code Ends
