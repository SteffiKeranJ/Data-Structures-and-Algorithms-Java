class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap();
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            if(numMap.containsKey(target-nums[i])) 
                return new int[] {numMap.get(target-nums[i]), i};
            numMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("no solution");
    }
}
