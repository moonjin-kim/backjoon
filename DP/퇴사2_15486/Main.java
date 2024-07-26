package cotest.dp.퇴사2_15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        dp = new int[N + 1];
        int[] time = new int[N + 1];
        int[] pay = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());

        }

        for(int i = 0; i <= N; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }

            int day = i + time[i];
            if(day < N+1) {
                dp[day] = Math.max(dp[day], max + pay[i]);
            }
        }

        System.out.println(max);
    }
}
