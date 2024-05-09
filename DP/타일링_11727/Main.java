package cotest.dp.타일링_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] dp = new int[len+1];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i <= len; i++) {
            dp[i] = (dp[i-1] + 2 *dp[i-2]) % 10007;
        }

        System.out.println(dp[len]);
    }
}
