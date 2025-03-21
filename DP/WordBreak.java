class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        int minWordSize = Integer.MAX_VALUE;
        int maxWordSize = Integer.MIN_VALUE;
        for(String word: wordDict) {
            int l = word.length();
            minWordSize = Math.min(minWordSize, l);
            maxWordSize = Math.max(maxWordSize, l);
        }
        dp[0] = true;
        for(int i = minWordSize; i <=n; ++i) {
            for(int j = Math.max(i-maxWordSize, 0); j <= i-minWordSize; ++j) {
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
