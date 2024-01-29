/**
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]

**/
class Solution {
    static int l;
    private List<List<String>> result = new ArrayList<>();
    private List<String> subSet = new ArrayList<>();
    public List<List<String>> partition(String s) {
        l = s.length();
        backTrackHelper(0, s);
        return result;    
    }

    private void backTrackHelper(int start, String s) {
        if(start == l) {
            result.add(new ArrayList<>(subSet));
            return;
        }
        for(int i = start; i < l; ++i) {
            if(!isPalindrome(start, i, s)) continue;
            subSet.add(s.substring(start, i+1));
            backTrackHelper(i+1, s);
            subSet.remove(subSet.size() - 1);
        }
    }

    private static boolean isPalindrome(int start, int end, String s) {
        while(start < end ) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
