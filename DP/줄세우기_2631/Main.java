package cotest.dp.줄세우기_2631;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] student = new int[n];
        int[] dp = new int[n];
        int lis = 0;

        for (int i = 0; i < n; i++) {
            student[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (student[j] < student[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                if (dp[i] == 0) {
                    dp[i] = 1;
                }
            }
            lis = Math.max(lis, dp[i]);
        }

        System.out.println(n-lis);

    }
}
