```

96. Unique Binary Search Trees

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.


Example 1:

Input: n = 3
Output: 5

Example 2:

Input: n = 1
Output: 1

```


class Solution {
    public int numTrees(int n) {
        int[] dp = new int[20];
        Arrays.fill(dp,0);
        dp[0] = dp[1] = 1;
        int i, j;
        for(i = 2; i <=n; ++i){
            for(j=1; j<=i; ++j){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
