package middle.day22.로만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];

        dp[1] = 0;

        for(int i=2;i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if(i % 3 == 0) {
                min = Math.min(min, dp[i/3]+1);
            }
            if (i % 2 == 0) {
                min = Math.min(min, dp[i/2]+1);
            }
            min = Math.min(min, dp[i-1]+1);

            dp[i] = min;
        }
        System.out.println(dp[n]);
    }
}
