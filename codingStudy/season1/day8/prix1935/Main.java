package day8.prix1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Double[] nums = new Double[N];
        for(int i = 0; i< N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Double> deque = new ArrayDeque<>();

        for(char chr : str.toCharArray()) {
            double result = 0;

            if(chr - 65 >= 0 && chr - 65 <= 26) {
                deque.push(nums[chr-65]);
            } else {
                double a = deque.pop();
                double b = deque.pop();
                if (chr == '+') {
                    deque.push(a+b);
                } else if (chr == '-') {
                    deque.push(b-a);
                } else if (chr == '*') {
                    deque.push(a*b);
                } else if (chr == '/') {
                    deque.push(b/a);
                }
            }
        }

        System.out.printf("%.2f%n", deque.pop());

    }
}
