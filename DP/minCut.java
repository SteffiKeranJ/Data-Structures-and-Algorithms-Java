/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.
Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:

Input: s = "a"
Output: 0

Example 3:

Input: s = "ab"
Output: 1

**/
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = -1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                String substr = s.substring(j-1, i);
                if(isPalindrome(substr)) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[i-1] + 1);
                }
            }
        }
        return dp[n];
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n-1;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
