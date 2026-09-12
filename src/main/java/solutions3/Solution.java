package solutions3;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> anagramGroup = new ArrayList<>();
        Map<String, List<String>> wordMap = new HashMap<>();

        for(String str: strs){
           String sortedString = getSignature(str);
           List<String> wordList = wordMap.getOrDefault(sortedString, new ArrayList<String>());
           wordList.add(str);
           wordMap.put(sortedString, wordList);
        }

        for(List<String> wordList: wordMap.values()){
            anagramGroup.add(wordList);
        }
        return anagramGroup;
    }



    private String getSignature(String word) {
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        return Arrays.toString(count);
    }
}
