package day9.stack1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] sequence = new int[N];
        int idx = 0;

        for(int i=0; i<N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++) {
            if(i < sequence[idx]) {
                stack.push(i);
                sb.append('+').append('\n');
            } else {
                stack.push(i);
                sb.append('+').append('\n');
                while(!stack.isEmpty()&&stack.peek() == sequence[idx]) {
                    stack.pop();
                    sb.append('-').append('\n');
                    idx++;
                }
            }
        }

        if(idx != N) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
