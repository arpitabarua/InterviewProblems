package solutions8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solutions {
    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        boolean output = solutions.isIsomorphic("foo", "bar");
        System.out.println(output);
    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mapForFirstString = new HashMap<>();
        Map<Character, Character> mapForSecondString = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char firstChar = s.charAt(i);
            char secondChar = t.charAt(i);

            if(mapForFirstString.containsKey(firstChar) && mapForFirstString.get(firstChar) != secondChar){
                return false;
            } else {
                mapForFirstString.put(firstChar, secondChar);
            }

            if(mapForSecondString.containsKey(secondChar) && mapForSecondString.get(secondChar) != firstChar){
                return false;
            } else {
                mapForSecondString.put(secondChar, firstChar);
            }

        }

        return true;
    }


}
