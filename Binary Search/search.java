class Solution {
    public int search(int[] nums, int target) {
       
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = low + high >> 1;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
