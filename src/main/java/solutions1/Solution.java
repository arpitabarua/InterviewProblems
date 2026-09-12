package solutions1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
public class Solution {
    public static void main(String[] args) {
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLength = 0;
        int currLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        int i =0;
        while(i < s.length() ){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int newLength = i - map.get(c);
                currLength = Math.min(newLength, currLength+1);
                map.put(c, i);
                //  System.out.println("i "+i+" currLength "+currLength);
            } else
            {
                map.put(c, i);
                currLength++;
                //   System.out.println("i "+i+" currLength "+currLength);
            }

            maxLength = Math.max(maxLength, currLength);
            i++;

        }

        maxLength = Math.max(maxLength, currLength);

        return maxLength;
    }
}
