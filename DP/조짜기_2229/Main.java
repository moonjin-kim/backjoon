package cotest.dp.조짜기_2229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] dp = new int[N+1];
        int[] sum = new int[N+1];
        for(int i = 1; i <= N; i++) {
            int max = 0, min = 10001;
            sum[i] = Integer.parseInt(line[i - 1]);

            for(int j = i; j > 0; j--) {
                max = Math.max(max, sum[j]);
                min = Math.min(min, sum[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}
