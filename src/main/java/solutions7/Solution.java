package solutions7;

import java.util.Arrays;

/**
 * You are given a 0-indexed string array words having length n and containing 0-indexed strings.
 *
 * You are allowed to perform the following operation any number of times (including zero):
 *
 * Choose integers i, j, x, and y such that 0 <= i, j < n, 0 <= x < words[i].length, 0 <= y < words[j].length, and swap the characters words[i][x] and words[j][y].
 * Return an integer denoting the maximum number of palindromes words can contain, after performing some operations.
 *
 * Note: i and j may be equal during an operation.
 */
public class Solution {
    public static void main(String[] args) {
        String[] words = {"abbb","ba","aa"};
        Solution solution = new Solution();
        System.out.println(solution.maxPalindromesAfterOperations(words));
    }
    public int maxPalindromesAfterOperations(String[] words) {

        int[] counts = getCounts(words);
        int pairs = 0;
        for(int count: counts){
            pairs += count / 2;
        }
        int singles = 0;
        for(int count: counts){
            singles += count % 2;
        }
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        return getMaxPalindromes(words, singles, pairs);

    }

    private int getMaxPalindromes(String[] words, int singles, int pairs){
        int palindromeCount = 0;
        for(String word: words){
            if(word.length() % 2 == 0){
                int neededPairs = word.length() / 2;
                if(pairs >= neededPairs){
                    pairs -= neededPairs;
                    palindromeCount++;
                }
            } else {
                int neededPairs = word.length() / 2;
                if(pairs >= neededPairs ){
                    if(singles > 0){
                        pairs -= neededPairs;
                        palindromeCount++;
                        singles--;
                    } else {// break a pair
                        if(pairs>0){
                            pairs -= neededPairs;
                            pairs--;
                            singles++;
                            palindromeCount++;
                        }

                    }
                }

            }

        }
        return palindromeCount;
    }

    private int[] getCounts(String[] words){
        int [] counts = new int[26];

        for(String word: words){
            for(char c: word.toCharArray()){
                counts[c - 'a']++;
            }
        }

       return counts;
    }


}
