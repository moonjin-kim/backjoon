package cotest.dp.케익배달_2159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;
    static int[] dx = {0, 0, -1, 0, 1};
    static int[] dy = {0, -1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1][5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int beforeX = Integer.parseInt(st.nextToken());
        int beforeY = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 5; i++) {
            dp[1][i] = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                if(beforeX + dx[j] > 100000 || beforeY + dy[j] > 100000) continue;
                if(beforeX + dx[j] < 0 || beforeY + dy[j] < 0) continue;
                if(startX + dx[j] > 100000 || startY + dy[j] > 100000) continue;
                if(startX + dx[j] < 0 || startY + dy[j] < 0) continue;
                long tmp = Math.abs(beforeX + dx[i] - startX) + Math.abs(beforeY + dy[i] - startY);
                dp[1][i] = Math.min(dp[1][i], tmp);
            }
        }

        for (int k = 2; k <= n; k++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 5; i++) {
                dp[k][i] = Integer.MAX_VALUE;
                for (int j = 0; j < 5; j++) {
                    if(beforeX + dx[j] > 100000 || beforeY + dy[j] > 100000) continue;
                    if(beforeX + dx[j] < 0 || beforeY + dy[j] < 0) continue;
                    if(X + dx[j] > 100000 || Y + dy[j] > 100000) continue;
                    if(X + dx[j] < 0 || Y + dy[j] < 0) continue;
                    long tmp = dp[k-1][j] + Math.abs(X + dx[i] - (beforeX + dx[j])) + Math.abs(Y + dy[i] - (beforeY + dy[j]));
                    dp[k][i] = Math.min(dp[k][i], tmp);
                }
            }
            beforeX = X;
            beforeY = Y;
        }

        long min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            min = Math.min(min, dp[n][i]);
        }

        System.out.println(min);
    }
}
