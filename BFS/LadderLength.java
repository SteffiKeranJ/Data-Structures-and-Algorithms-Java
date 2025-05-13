/*
127. Word Ladder


A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

*/

class Solution {
    List<Integer>[] adjList;

    private int findDistance(String word1, String word2) {
        int n = word1.length();
        int counter = 0;
        for(int i = 0; i < n; ++i) {
            if(word1.charAt(i) != word2.charAt(i)) counter++;
            if(counter > 1) return counter;
        }
        return counter;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int nL = wordList.size();
        adjList = new ArrayList[nL+1];
        for(int i = 0; i <= nL; ++i) {
            adjList[i] = new ArrayList<>();
        }

        if(!wordList.contains(endWord)) return 0;

        for(int i = 0; i < nL; ++i) {
            if(findDistance(beginWord, wordList.get(i)) == 1) {
                adjList[0].add(i+1);
            }
        } 

        for(int i = 0; i < nL-1; ++i) {
            for(int j = i+1; j < nL; ++j) {
                if(findDistance(wordList.get(i), wordList.get(j)) == 1) {
                    adjList[i+1].add(j+1); 
                    adjList[j+1].add(i+1);
                }
            }
        }

        boolean[] visited = new boolean[nL+1];

        Queue<Integer> q = new LinkedList<>();

        int ql, level = 1;

        q.offer(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            
             ql = q.size();

            for(int i = 0; i < ql; ++i) {
                int node = q.poll();
                
                for(int j = 0; j < adjList[node].size(); ++j) {
                
                    int neighbor = adjList[node].get(j) - 1;

                    if(!visited[neighbor+1]) {
                        
                        if(wordList.get(neighbor).equals(endWord)) return level+1;
                        
                        q.offer(neighbor+1);
                        visited[node] = true;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
