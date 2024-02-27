package day13.test2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        Stack<Character> stack = new Stack<>();
        int value = 1;
        int result = 0;
        for(int i=0; i < expression.length(); i++) {
            char str = expression.charAt(i);

            if(str=='(') {
                value *= 2;
                stack.add('(');
            } else if (str=='[') {
                value *= 3;
                stack.add('[');
            } else if (str==')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(expression.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if (str==']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if(expression.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}
