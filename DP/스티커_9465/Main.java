package cotest.스티zj_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] sticker;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[n][2];
            dp = new int[n][2];
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sticker[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sticker[j][1] = Integer.parseInt(st.nextToken());
            }

            select();

            System.out.println(answer);
        }
    }

    public static void select() {
        dp[0][0] = sticker[0][0];
        dp[0][1] = sticker[0][1];
        if(n > 1) {
            dp[1][0] = sticker[1][0] + dp[0][1];
            dp[1][1] = sticker[1][1] + dp[0][0];

            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1] + sticker[i][0], dp[i - 2][0]+ sticker[i][0]);
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][1] + sticker[i][0]);
                dp[i][1] = Math.max(dp[i - 1][0] + sticker[i][1], dp[i - 2][0]+ sticker[i][1]);
                dp[i][1] = Math.max(dp[i][1], dp[i - 2][1] + sticker[i][1]);
            }
        }


        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][1]);
            answer = Math.max(answer, dp[i][0]);
        }
    }
}
