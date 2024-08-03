package cotest.dp.가장_큰_정사각형_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] map;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                int k = str.charAt(j) - '0';
                map[i][j] = k;
                max = Math.max(max, k);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    // x좌표의 길이
                    if(i == 0 || j == 0 || map[i][j] == 0) continue;

                    map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
                    max = Math.max(max, map[i][j]);
                }
            }
        }

        System.out.println(max * max);
    }
}
