```
5. Longest Palindromic Substring

Given a string s, return the longest
palindromic
substring
in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters
```



class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[1001][1001];
        for(int i = 0; i < n; ++i) dp[i][i] = true;

        String result = "";
        result += s.charAt(0);

        for(int i = n-1; i >=0 ; --i) {
            for(int j = i+1; j < n; ++j) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        if(result.length() < j-i+1) 
                            result = s.substring(i, j+1);
                    } 
                }
            }
        }
        return result;
    }
}
