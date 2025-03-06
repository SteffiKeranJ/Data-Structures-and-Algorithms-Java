/**
Given a string s, find the length of the longest

without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int n = s.length();
        int best = 0, curr = 0;
        int l = 0, r = 0;
        while(r < n) {
            Character ch = s.charAt(r);
            if(!freqMap.containsKey(ch)) curr++;
            else {
                if(freqMap.get(ch) < l) curr++;
                else {
                    l = freqMap.get(ch) + 1;
                    curr = r - l +1;
                }
            }
            freqMap.put(ch, r);
            best = Math.max(best, r-l+1);
            r++;
        }
        return best;
    }
}
