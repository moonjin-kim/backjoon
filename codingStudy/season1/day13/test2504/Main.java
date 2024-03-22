package day13.test2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char chr = expression.charAt(i);

            if(chr == '(' || chr == '[') {
                stack.add(String.valueOf(chr));
            } else if (chr == ')') {
                if(i == 0 || expression.charAt(i-1) == '[') {
                    System.out.println(0);
                    System.exit(0);
                } else if(expression.charAt(i-1) == '(') {
                    stack.pop();
                    stack.add("2");
                }else {
                    int sum = 0;
                    while(!stack.isEmpty() &&!stack.peek().equals("(")) {
                        String a = stack.pop();
                        if(a.equals("[") || a.equals("(")) {

                            System.out.println(0);
                            System.exit(0);
                        }
                        sum += Integer.parseInt(a) ;
                    }

                    if(stack.isEmpty()) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    stack.pop();
                    stack.add(String.valueOf(sum * 2));
                }
            } else if (chr == ']') {
                if(i == 0 || expression.charAt(i-1) == '(') {
                    System.out.println(0);
                    System.exit(0);
                } else if(expression.charAt(i-1) == '[') {
                    stack.pop();
                    stack.add("3");
                } else {
                    int sum = 0;
                    while(!stack.isEmpty() &&!stack.peek().equals("[")) {
                        String a = stack.pop();
                        if(a.equals("[") || a.equals("(")) {

                            System.out.println(0);
                            System.exit(0);
                        }
                        sum += Integer.parseInt(a) ;
                    }

                    if(stack.isEmpty()) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    stack.pop();
                    stack.add(String.valueOf(sum*3));
                }
            }
        }


        int answer = 0;
        while(!stack.isEmpty()) {
            String a = stack.pop();
            if(a.equals("(") || a.equals("[") || a.equals(")") || a.equals("]")) {
                System.out.println(0);
                System.exit(0);
            }
            answer += Integer.parseInt(a);
        }

        System.out.println(answer);


    }
}
