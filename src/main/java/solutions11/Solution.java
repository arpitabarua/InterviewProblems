package solutions11;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int dist = solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(dist);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue = new LinkedList<>();

        Node startNode = new Node();
        startNode.currentWord = beginWord;
        startNode.level = 1;
        queue.add(startNode);
        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            for(String word: wordList){
                if(!visited.contains(word) && isOneLetterDiff(word, currentNode.currentWord)){

                    Node newNode = new Node();
                    newNode.currentWord = word;
                    newNode.level = currentNode.level + 1;
                    if(word.equals(endWord)){
                       // System.out.println("Found "+newNode.pastWords);
                        return newNode.level;
                    }
                    visited.add(word);
                    queue.add(newNode);
                }

            }

        }
        return 0;

    }

    private boolean isOneLetterDiff(String word1, String word2){
        int count = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }

        return count ==1;
    }
}

class Node {

    String currentWord;
    int level = 0;

}
