/**
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]

Constraints:

    1 <= s.length <= 12
    s consists of lowercase English letters, uppercase English letters, and digits.
**/

class Solution {
    private int n;
    private Set<String> resultSet = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        n = s.length();
        char[] charArray = s.toCharArray();
        backTrack(charArray, 0);
        return new ArrayList<>(resultSet);
    }

    private void backTrack(char[] charArray, int index) {
        if(index >= n) {
            String possibleString = new String(charArray);

            if(!resultSet.contains(possibleString)) {
                resultSet.add(possibleString);
            }
            return;
        }

        backTrack(charArray, index+1);

        charArray[index] = swapCase(charArray[index]);

        backTrack(charArray, index+1);
    }

    private char swapCase(char ch) {
        return Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
    }
}
