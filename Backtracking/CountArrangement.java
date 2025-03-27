/*
Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

    perm[i] is divisible by i.
    i is divisible by perm[i].

Given an integer n, return the number of the beautiful arrangements that you can construct.

 

Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1

Example 2:

Input: n = 1
Output: 1

*/

class Solution {
    int count = 0;
    public int countArrangement(int n) {
        if(n == 1) return 1;
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = i+1;
        boolean[] used = new boolean[n];
        backtrack(n, nums,new ArrayList<Integer>(),used);
        return count;
    }
    

    private void backtrack(int n, int[] nums, List<Integer> temp, boolean[] used) {
        if(temp.size() == n) {
            count++;
            return;
        } 

        int pos = temp.size()+1;

        for(int i = 0; i < n; ++i) {
            if(used[i]) continue;
            if((nums[i]%pos != 0 && pos%nums[i] !=0)) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(n,nums,temp, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }

}
