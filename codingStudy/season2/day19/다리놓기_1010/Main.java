package middle.day19.다리놓기_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 2번 성질 (n == r, r == 0)
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                // 1번 성질
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }


        for(int i=0; i<n ;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(dp[b][a]);
        }

    }

    static int combination(int a, int b) {
        if (dp[a][b] > 0) {
            return dp[a][b];
        } else if (a==b || b == 0) {
            return dp[a][b] = 1;
        } else {
            return dp[a][b] = combination(a-1,b-1) + combination(a-1,b);
        }
    }
}
