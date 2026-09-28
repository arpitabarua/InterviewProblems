package solutions6;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "vzhofnpo";
        Solution solution = new Solution();
        System.out.println(solution.robotWithString(s));
    }

    public String robotWithString(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] minArray = buildMin(s);
        int i =0;
        while(i< s.length()){
            if(stack.isEmpty()){
                char currentChar = s.charAt(i);
                stack.push(currentChar);
                i++;

            }
            char top = stack.peek();
            if(i >= s.length() || top <= minArray[i]){
                sb.append(stack.pop());
            } else {
                stack.push(s.charAt(i));

                i++;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }



        return sb.toString();

    }


    private char[] buildMin(String s){
        char[]minChars = new char[s.length()];
        char currentMin = s.charAt(s.length()-1);
        for(int i = s.length()-1; i >=0; i--){
            if(currentMin > s.charAt(i)){
                currentMin = s.charAt(i);
                minChars[i] = currentMin;
            } else {
                minChars[i] = currentMin;
            }
        }

        return minChars;
    }
}
