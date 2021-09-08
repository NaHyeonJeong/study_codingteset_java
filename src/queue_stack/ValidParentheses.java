package queue_stack;

import java.util.Stack;

/**
 * 유효한 괄호 문제
 *
 * 가장 기본적인 stack
 * 괄호? 계산기? 그러면 stack 사용
 */
public class ValidParentheses {

    public static void main(String[] args) {
        //String str= "()[]{}"  ;//true;
        //String str= "(}"  ;//false;
        String exp = "([}}])";
        System.out.println(solve(exp));
    }

    public static boolean solve(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '('){
                stack.pop();
            } else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '['){
                stack.pop();
            } else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{'){
                stack.pop();
            } else{
                return false;
            }
        }
        return stack.empty();
    }
}
