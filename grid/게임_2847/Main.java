package cotest.greed.게임_2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int[] min = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
            min[i] = score[i];
        }

        for (int i = n-2; i >= 0; i--) {
            if(score[i] >= score[i+1]) { // 낮은 레벨의 점수가 높은 레벨보다 크거나 같은 경우
                int diff = score[i] - score[i+1] + 1; //n번째 수가 n+1보다 1만큼 작게 하기 위한 차이
                ans += diff;
                score[i] -= diff;
            }
        }

        System.out.println(ans);
    }
}
