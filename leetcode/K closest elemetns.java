// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

// An integer a is closer to x than an integer b if:

// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b
 

// Example 1:

// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]
// Example 2:

// Input: arr = [1,2,3,4,5], k = 4, x = -1
// Output: [1,2,3,4]

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int n = arr.length;
        int right = n-1;
        while(right - left > k-1){
            if(Math.abs(arr[left]-x)<= Math.abs(arr[right]-x))right--;
            else left++;
        }
        while(left <= right){
            ans.add(arr[left++]);
        }
        return ans;
    }
}
