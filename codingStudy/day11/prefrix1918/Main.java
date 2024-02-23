package day11.prefrix1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char text : expression.toCharArray()) {
            switch (text) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(text)) {
                        sb.append(stack.pop());
                    }
                    stack.add(text);
                    break;
                case '(':
                    stack.add(text);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(text);
            }



        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int priority(char temp) {
        if(temp == '(') return 0;
        if(temp == '+' || temp == '-') return 1;
        else return 2;
    }
}
