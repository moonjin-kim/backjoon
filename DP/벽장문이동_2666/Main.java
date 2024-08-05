package cotest.dp.벽장문이동_2666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int case1 = Integer.parseInt(br.readLine());

        target = new int[case1];
        for (int i = 0; i < case1; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(a,b,0));

    }

    static int solve(int a, int b, int cnt) {
        if(cnt == target.length) return 0;

        int tmp1 = Math.abs(a-target[cnt]);
        int tmp2 = Math.abs(b-target[cnt]);

        return Math.min(tmp1 + solve(target[cnt], b, cnt + 1), tmp2 + solve(a, target[cnt], cnt + 1));
    }
}
