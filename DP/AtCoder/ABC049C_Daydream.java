/*
ABC049C - Daydream 
https://atcoder.jp/contests/abs/tasks/arc065_a

Similar to LC WordBreak
*/

import java.util.HashSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        String s = scanner.next();
        int n = s.length();

        HashSet<String> wordDict = new HashSet<>();
        wordDict.add("dream");
        wordDict.add("dreamer");
        wordDict.add("erase");
        wordDict.add("eraser");

        
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

        
        System.out.println(dp[n] == true ? "YES" : "NO");

        scanner.close();
    }
}
