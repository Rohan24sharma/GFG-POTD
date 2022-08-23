// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
  
 

// Example 1:


// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.
// Example 2:

// Input: matrix = [["0"]]
// Output: 0
// Example 3:

// Input: matrix = [["1"]]
// Output: 1


class Solution {
    public int maximalRectangle(char[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] arr = new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                arr[i][j] =mat[i][j]-'0';
        int res=largestHist(arr[0] ,c);
        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==1)
                 arr[i][j] +=arr[i-1][j];
            }
            res = Math.max(res , largestHist(arr[i], c));
        }
        return res;
    }
    public int largestHist(int[] arr ,  int n){
        Stack<Integer> s =  new Stack<>();
        int ans = 0;
        int top=0,curr=0;
       int i=0;
        while(i<n){
            if(s.isEmpty() || arr[s.peek()] <=arr[i])
                s.push(i++);
            else{
                top = s.peek();
                s.pop();
                curr = arr[top]*(s.isEmpty() ? i:i-s.peek()-1);
                ans = Math.max(ans ,curr);
            }
        }
        while(!s.isEmpty()){
            top = s.pop();
            curr = arr[top]*(s.isEmpty()?n : n-s.peek()-1);
            ans = Math.max(ans , curr);
        }
        return ans;
    }
}
