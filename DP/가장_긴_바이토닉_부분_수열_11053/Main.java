package cotest.dp.가장_긴_바이토닉_부분_수열_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열 arr의 길이
        int[] arr = new int[n+1];  //수열 배열 초기화
        int[] dp1 = new int[n+1];  //dp 테이블 초기화
        int[] dp2 = new int[n+1];  //dp 테이블 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //arr에 수열 입력 받기
            dp1[i] = 1;  //모든 dp값들은 최소 1
            dp2[i] = 1;  //모든 dp값들은 최소 1
        }
        int max1 = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) dp1[i] = Math.max(dp1[i], dp1[j]+1);
                // 이전 원소들 중 가장 큰 dp값 + 1
            }
        }

        int max2 = 1;
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
                // 이전 원소들 중 가장 큰 dp값 + 1
            }//LIS 길이 구하기
        }

        int max=1;
        for(int i=1; i<=n;i++) {
            max = Math.max(max, dp1[i] + dp2[i]);
        }
        System.out.println(max-1);
    }

}
