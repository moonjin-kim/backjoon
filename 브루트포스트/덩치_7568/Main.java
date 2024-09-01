package cotest.브루트포스트.덩치_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] humans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        humans = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            humans[i][0] = Integer.parseInt(st.nextToken());
            humans[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int answer = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (humans[i][0] < humans[j][0] && humans[i][1] < humans[j][1]) answer++;
            }
            System.out.println(answer);
        }
    }
}
