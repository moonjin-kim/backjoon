package day10.steelbar10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bar = br.readLine();
        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        char[] str = bar.toCharArray();


        for(int i=0; i < str.length; i++) {
            char currentChar = str[i];

            //현재 char이 ( 이면 stack에 저장
            if(currentChar == '(') {
                stack.push(i);
            } else {
                int idx = stack.pop();
                //마지막 ( 이 이전 idx이면 레이저 임으로 stack에 남아있는 (의 개수가 막대의 개수임으로 개수만큼 자름
                if(idx == i - 1) {
                    answer += stack.size();
                } else { //막대의 마지막 부분임으로 1개만 추가
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
