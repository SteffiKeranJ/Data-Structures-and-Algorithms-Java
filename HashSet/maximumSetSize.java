/**
You are given two 0-indexed integer arrays nums1 and nums2 of even length n.

You must remove n / 2 elements from nums1 and n / 2 elements from nums2. After the removals, you insert the remaining elements of nums1 and nums2 into a set s.

Return the maximum possible size of the set s.

Input: nums1 = [1,2,1,2], nums2 = [1,1,1,1]
Output: 2

Input: nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
Output: 5

Input: nums1 = [1,1,2,2,3,3], nums2 = [4,4,5,5,6,6]
Output: 6

**/

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashSet<Integer> numSet1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> numSet2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));
        
        HashSet<Integer> mergedSet = new HashSet<>(numSet1);
        mergedSet.addAll(numSet2);

        return Math.min(Math.min(numSet1.size(), nums1.length/2) + Math.min(numSet2.size(), nums2.length/2), mergedSet.size());
    }
}
