/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

    Only numbers 1 through 9 are used.
    Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

 

Constraints:

    2 <= k <= 9
    1 <= n <= 60


*/
class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new HashSet<>();
        
        for(int i = 1; i <= n; ++i) {
            backtrackHelper(new boolean[10], k, new ArrayList<Integer>(), 0, i, n);
        }
        return new ArrayList<>(result);
    }

    private void backtrackHelper(boolean[] used, int k, List<Integer> temp, int tempSum, int index, int n) {
        if(temp.size() > k || tempSum > n) return;
        if(temp.size() == k && tempSum == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(index > 9) return;
        temp.add(index);
        backtrackHelper(used, k, temp, tempSum+index, index+1, n);
        temp.remove(temp.size()-1);
        backtrackHelper(used, k, temp, tempSum, index+1, n);
    }
}
