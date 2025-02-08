/*
https://leetcode.com/problems/longest-consecutive-sequence/description/
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numset = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int best = 0;
        for(Integer num: numset) {
            if(!numset.contains(num - 1)) {
                int y = num+1;
                while(numset.contains(y)) y++;
                best = Math.max(best, y-num);
            }
        }
        return best;
    }
}
