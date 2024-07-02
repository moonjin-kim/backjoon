package cotest.dp.피보나치_24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int recursionCount = 0;
    static int dpCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib(N);
        fib2(N);
        System.out.println(recursionCount + " " + dpCount);
    }

    public static int fib(int n) {
        if (n == 1 | n == 2) {

            recursionCount++;
            return 1;
        }

        return (fib(n - 1) + fib(n - 2));
    }

    public static int fib2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dpCount++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
