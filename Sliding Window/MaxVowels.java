/**
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

**/
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int tempSum = 0;
        for(int i = 0; i < k; ++i) {
            if(vowelSet.contains(s.charAt(i))) {
                tempSum++;
            }
        }
        int result = tempSum;

        for(int i = k; i < n; ++i) {
            if(vowelSet.contains(s.charAt(i-k))) tempSum--;
            if(vowelSet.contains(s.charAt(i))) tempSum++;
            result = Math.max(result, tempSum);
        }

        return result;
    }
}
