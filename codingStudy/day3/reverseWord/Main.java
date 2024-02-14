package day3.reverseWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack<Character> reverseStack = new Stack<>();
        boolean isReverse = true;

        for(int i=0; i <word.length();i++) {
            char s = word.charAt(i);
            // <을 만났을 경우 스택에 존재하는 단어들을 모두 꺼내고 isReverse를 false로
            if(s == '<') {
                isReverse = false;
                while(!reverseStack.isEmpty()) {
                    System.out.print(reverseStack.pop());
                }
            } else if (s == '>') { //>을 만났을 경우 >을 출력하고 isReverse를 true
                isReverse = true;
                System.out.print('>');
                continue;
            }

            //>을 false일 경우 '>'을 만나기 전까지 그대로 입력
            if(!isReverse) {
                System.out.print(s);
            } else {
                if(s == ' ') {
                    while(!reverseStack.isEmpty()) {
                        System.out.print(reverseStack.pop());
                    }
                    System.out.print(" ");
                } else {
                    reverseStack.add(s);
                }
            }
        }

        while(!reverseStack.isEmpty()) {
            System.out.print(reverseStack.pop());
        }
    }
}
