/**
You are given a string s and a character c. Return the total number of
substrings
Substring

A substring is a contiguous non-empty sequence of characters within a string.
of s that start and end with c.

 

Example 1:

Input: s = "abada", c = "a"

Output: 6

Explanation: Substrings starting and ending with "a" are: "abada", "abada", "abada", "abada", "abada", "abada".

Example 2:

Input: s = "zzz", c = "z"

Output: 6

Explanation: There are a total of 6 substrings in s and all start and end with "z".

**/
class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        char charArray[] = s.toCharArray();
        for(char ch: charArray) {
            if(ch == c) {
                count++;
            }
        }
        return count + (count*(count-1)>>1);
    }
}

