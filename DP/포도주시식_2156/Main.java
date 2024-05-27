package cotest.dp.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] wine = new int[len+1];
        int[] dp = new int[len+1];

        for(int i=1; i<len+1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[1];
        if(len > 1) {
            dp[2] = wine[1] + wine[2];
        }

        for(int i = 3; i<=len; i++) {
            dp[i] = Math.max(
                    dp[i-1], //이전 선택이 2번째 선택
                    Math.max(dp[i-2] + wine[i],
                            dp[i-3] + wine[i-1] + wine[i]
                    )
            );
        }

        System.out.println(dp[len]);
    }
}
