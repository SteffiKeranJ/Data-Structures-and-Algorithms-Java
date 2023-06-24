/**
https://leetcode.com/problems/substring-with-concatenation-of-all-words

30. Substring with Concatenation of All Words

You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

    For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.

Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
*/


class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> freqMap = new HashMap<>();

        for (final String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        final List<Integer> result = new ArrayList<>();

        final int n = s.length(), num = words.length, l = words[0].length();
        
        for (int i = 0; i < n - num * l + 1; i++) {
            final Map<String, Integer> present = new HashMap<>();
            
            int j = 0;

            while (j < num) {
                final String word = s.substring(i + j * l, i + (j + 1) * l);
                if (freqMap.containsKey(word)) {
                    present.put(word, present.getOrDefault(word, 0) + 1);
                    if (present.get(word) > freqMap.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                result.add(i);
            }
        }
        return result;
    }
}
