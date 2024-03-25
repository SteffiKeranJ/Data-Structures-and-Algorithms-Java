/**
Given a string s, return the maximum length of a
substring
 such that it contains at most two occurrences of each character.

 

Example 1:

Input: s = "bcbbbcba"

Output: 4

Explanation:
The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".

Example 2:

Input: s = "aaaa"

Output: 2

Explanation:
The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
**/

class Solution {
    public int maximumLengthSubstring(String s) {
        int result = 0;
        int freq[] = new int[26];
        int n = s.length();
        int begin = 0;
        int end = 0;
        char charArr[] = s.toCharArray();
        while(end < n) {
            freq[s.charAt(end)-'a']++;
            while(freq[s.charAt(end) - 'a'] == 3) {
                freq[s.charAt(begin++) - 'a']--;
            }
            result = Math.max(result, end - begin + 1);
            end++;
        }
        return result;
    }
}
