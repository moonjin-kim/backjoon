package cotest.dp.피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        dp = new int[41][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            System.out.println(dp[x][0] + " " + dp[x][1]);
        }
    }
}
