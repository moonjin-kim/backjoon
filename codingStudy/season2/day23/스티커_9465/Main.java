package middle.day23.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//todo: 내일 다시 풀어봅시다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n+1];
            int[][]	dp = new int[2][n+1];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<n+1; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        }
    }
}
