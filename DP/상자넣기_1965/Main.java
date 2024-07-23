package cotest.dp.상자넣기_1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열 arr의 길이
        int answer = 0;
        int[] data = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(data[i] > data[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
