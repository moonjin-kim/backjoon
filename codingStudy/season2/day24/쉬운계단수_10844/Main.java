package middle.day24.쉬운계단수_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[101][10];

        for(int i=1; i<10; i++) {
            arr[1][i] = 1;
        }

        for(int i=2; i<=n; i++) {
            arr[i][0] = arr[i-1][1] % MOD;
            for(int j=1; i<9; i++) {
                arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % MOD;
            }
            arr[i][9] = arr[i-1][8] % MOD;
        }

        long result = 0;
        for(int i = 0; i < 10; i++) {
            result += arr[n][i];
        }

        System.out.println(result % MOD);
    }
}
