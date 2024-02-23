package day11.goodword3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(checkGoodWord(word)) answer++;

        }

        System.out.println(answer);
    }

    static boolean checkGoodWord(String s) {
        if(s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for(char text : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == text) {
                stack.pop();
            } else{
                stack.add(text);
            }
        }

        return stack.isEmpty();
    }
}
