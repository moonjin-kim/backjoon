package cotest.팩토리얼2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.println(factorial(N));
    }

    public static long factorial(long n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
