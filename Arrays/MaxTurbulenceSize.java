/**
Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

    For i <= k < j:
        arr[k] > arr[k + 1] when k is odd, and
        arr[k] < arr[k + 1] when k is even.
    Or, for i <= k < j:
        arr[k] > arr[k + 1] when k is even, and
        arr[k] < arr[k + 1] when k is odd.

Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

Example 2:

Input: arr = [4,8,12,16]
Output: 2

**/
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        int maxSize = 1;
        if(n == 1) return maxSize;

        int inc = 1, dec = 1;
        
        for(int i = 1; i < n; i++) {
            if(arr[i] < arr[i-1]) {
                dec = inc + 1;
                inc = 1;
            } else if(arr[i] > arr[i-1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            maxSize = Math.max(maxSize, Math.max(inc, dec));
        }
        return maxSize;
    }
}
