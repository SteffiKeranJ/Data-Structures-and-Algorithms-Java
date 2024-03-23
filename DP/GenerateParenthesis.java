/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

**/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, 0);
        return result;
    }

    void helper(List<String> result, String s, int openBrackets, int closedBrackets) {
        if(openBrackets == 0 && closedBrackets == 0) {
            result.add(s);
            return;
        }
        if(openBrackets > 0) {
            helper(result, s+"(", openBrackets-1, closedBrackets+1);
        }
        if(closedBrackets > 0) {
            helper(result, s+")", openBrackets, closedBrackets-1);
        }
    }
}
