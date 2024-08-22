package cotest.dp.정상회담2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 1;

        for(int i = 4; i <= n; i+=2) {
            for(int j =2; j <= i; j+=2){
                dp[i] = (dp[i] + dp[j-2] * dp[i - j]) % 987654321;
            }
        }

        System.out.println(dp[n]);
    }
}
