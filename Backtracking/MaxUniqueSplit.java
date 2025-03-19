/*
Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.

Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].

Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.

 

Constraints:

    1 <= s.length <= 16

    s contains only lower case English letters
*/
class Solution {
    private int recurseSplit(String s, HashSet<String> hashSet) {
        if(s.length() == 0) return hashSet.size();
        int n = s.length();
        int l = 1;
        int count = hashSet.size();
        while(l <= n) {
            String subStr = s.substring(0, l);
            if(!hashSet.contains(subStr)) {
                hashSet.add(subStr);
                count = Math.max(count, recurseSplit(s.substring(l), hashSet));
                hashSet.remove(subStr);
            }
            l++;
        }
        return count;
    }

    public int maxUniqueSplit(String s) {
        HashSet<String> hashSet = new HashSet<>();
        return recurseSplit(s, hashSet);
    }
}
