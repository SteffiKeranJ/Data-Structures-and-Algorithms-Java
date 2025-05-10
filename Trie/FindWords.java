/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

 

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 12
    board[i][j] is a lowercase English letter.
    1 <= words.length <= 3 * 104
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
    All the strings of words are unique.


*/

class Solution {
    Set<String> result;
    Trie root;

    class Trie {
        String word;
        Trie[] children;

        Trie() {
            this.word = null;
            this.children = new Trie[26];
        }

        void markExists(String word) {
            Trie cur = this;
            for(int i = 0; i < word.length(); ++i) {
                int d = word.charAt(i) - 'a';
                if(cur.children[d] == null) {
                    cur.children[d] = new Trie();
                }
                
                cur = cur.children[d];
            }
            cur.word = word;
        }

        void traverse(char[][] board, Trie root, int i, int j, int m, int n) {
            if(i < 0 || i >= m || j < 0 || j >= n ) return;
            char character = board[i][j];
            if(character == '#' || root.children[character-'a'] ==null ) return;

            root = root.children[character-'a'];
            if(root.word!=null) {
                result.add(root.word);
                root.word = null;
            }
            board[i][j] = '#';
            traverse(board, root, i+1, j, m, n); 
            traverse(board, root, i-1, j, m, n);
            traverse(board, root, i, j+1, m, n);
            traverse(board, root,  i, j-1, m, n);
            board[i][j] = character;

        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        result = new HashSet<>();

        root = new Trie();
        for(String word: words) {
            root.markExists(word);
        }

        Trie cur = root;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                root.traverse(board, root,  i, j, m, n);
            }
        }
        return new ArrayList<>(result);
    }
    
}

