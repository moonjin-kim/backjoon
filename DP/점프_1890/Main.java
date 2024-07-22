package cotest.dp.점프_1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int dist = Integer.parseInt(st.nextToken());
                int nX = i + dist;
                int nY = j + dist;
                if(dist == 0) continue;
                if(nX < N) dp[nX][j] += dp[i][j];
                if(nY < N) dp[i][nY] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
