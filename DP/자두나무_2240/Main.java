package cotest.dp.자두나무_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];

        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            int pos = Integer.parseInt(br.readLine());
            for (int j = 0; j < m+1; j++) {
                int curPos = 1;
                if(j == 0) {
                    if(pos == curPos) {
                        dp[i][j] = dp[i-1][j] + 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                    continue;
                }

                if(j % 2 == 1) {
                    curPos = 2;
                }

                if(pos == curPos) {
                    dp[i][j] = Math.max(dp[i-1][j]+1, dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
