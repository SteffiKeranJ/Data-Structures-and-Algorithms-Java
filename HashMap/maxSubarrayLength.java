/**
2958. Length of Longest Subarray With at Most K Frequency

You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.
**/

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int numsLength = nums.length;
        int tempLength;
        int result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0; 
        while(right < numsLength) {
            freqMap.merge(nums[right], 1, Integer::sum);
            while(left <=right && freqMap.get(nums[right]) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if(freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
            tempLength = right++ - left + 1;
            result = Math.max(tempLength, result);
        }
        return result;
    }
}
