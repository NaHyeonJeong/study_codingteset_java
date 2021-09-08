package queue_stack;

import java.util.Stack;

/**
 * 야구게임
 *
 * 전형적인 stack을 사용하는 문제
 */
public class BaseballGame {

    public static void main(String[] args) {
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strs));
    }

    public static int calPoints(String[] ops) {
        //1.
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        //2. for while
        for (String op : ops) {
            switch (op) {
                case "C": //가장 위의 데이터 삭제
                    stack.pop();
                    break;
                case "D": //가장 위의 값 * 2 하고 다시 넣기
                    stack.push(stack.peek() * 2);
                    break;
                case "+": //상위 2개 값 더하고 상위 2개 값 다시 넣고 더한 값도 넣고
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second);
                    stack.push(first);
                    stack.push(first + second);
                    break;
                default: //기본적으로는 char 문자를 일단 다 넣기
                    stack.push(Integer.valueOf(op));
            }
        }

        while (!stack.isEmpty()) { //스택의 모든 값 다 더하기
            sum += stack.pop();
        }
        return sum;
    }
}
