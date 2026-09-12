package solutions2;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class Solution {


    public boolean isValid(String s) {

        if(s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(ch.equals('(') || ch.equals('{') || ch.equals('[') ){
                stack.push(ch);
            } else if(ch.equals(')') || ch.equals(']') || ch.equals('}')){
                if(stack.isEmpty()){
                    return false;
                }
                if(ch.equals(')') && !stack.peek().equals('(')){
                    return false;
                }
                if(ch.equals(']') && !stack.peek().equals('[')){
                    return false;
                }
                if(ch.equals('}') && !stack.peek().equals('{')){
                    return false;
                }
                stack.pop();
            }


        }

        return stack.isEmpty();

    }
}
