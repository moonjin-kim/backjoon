package cotest.dp.카드구매하11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i/2; j++) {
                if(j == 0) {
                    dp[i] = cards[i];
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }
}
