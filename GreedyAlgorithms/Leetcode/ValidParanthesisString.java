/*
https://leetcode.com/problems/valid-parenthesis-string/
 */

package GreedyAlgorithms.Leetcode;

import java.util.Stack;

public class ValidParanthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> brackets = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();

        int length = s.length();
        for(int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            //for '('
            if(ch == '(') {
                brackets.push(i);
            }
            //for '*'
            else if(ch == '*') {
                asterisks.push(i);
            }
            //for ')'
            else if(!brackets.isEmpty()) {
                brackets.pop();
            }
            else if(!asterisks.isEmpty()) {
                asterisks.pop();
            }
            else {
                return false;
            }
        }

       while(!brackets.isEmpty()
               && !asterisks.isEmpty()
               && brackets.peek() < asterisks.peek()) {
           brackets.pop();
           asterisks.pop();
       }

       return brackets.isEmpty();
    }
}
