package cotest.dp.동전_9048;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); //수열 arr의 길이

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int[] coins = new int[a];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target+1];
            dp[0] = 1;
            for(int coin: coins) {
                for (int j = coin; j <= target; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            System.out.println(dp[target] + "\n");

        }

    }


}
