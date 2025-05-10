/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []

 

Constraints:

    1 <= s.length <= 20
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 10
    s and wordDict[i] consist of only lowercase English letters.
*/

class Solution {
    List<String> result;

    private void backtrack(String s, int n, String temp, int start, int end, Set<String> dict) {
        // add terminating condition
        if(start >= n) {
            result.add(temp.trim());
            return;
        }

        if(end > n) return;
    
        String right = s.substring(start, end);
        backtrack(s, n, temp, start, end+1, dict);

        if(dict.contains(right)) {
            temp+=right;
            temp+=" ";
            backtrack(s, n, temp, end, end+1, dict);
        }        
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        result = new ArrayList<>();
        Set<String> dict = new HashSet<String>(wordDict);
        backtrack(s, n, "", 0,1,dict);

        return result;
    }
}
