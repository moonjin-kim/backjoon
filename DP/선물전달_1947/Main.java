package cotest.dp.선물전달_1947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            dp[i] = ((i-1) * (dp[i-1] + dp[i-2])) % 1000000000;
        }

        System.out.println(dp[n]);
    }
}
