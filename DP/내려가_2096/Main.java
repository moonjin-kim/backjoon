package cotest.dp.내려가_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp_max;
    static int[] dp_min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열 arr의 길이
        dp_max = new int[3];
        dp_min = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp_max[0] = dp_min[0] = a1;
                dp_max[1] = dp_min[1] = a2;
                dp_max[2] = dp_min[2] = a3;
            } else {
                int beforeLeftMax = dp_max[0];
                int beforeRightMax = dp_max[2];
                dp_max[0] = Math.max(dp_max[0], dp_max[1]) + a1;
                dp_max[2] = Math.max(dp_max[2], dp_max[1]) + a3;
                dp_max[1] = Math.max(Math.max(beforeLeftMax, beforeRightMax), dp_max[1]) + a2;


                int beforeLeftMin = dp_min[0];
                int beforeRightMin = dp_min[2];
                dp_min[0] = Math.min(dp_min[0], dp_min[1]) + a1;
                dp_min[2] = Math.min(dp_min[2], dp_min[1]) + a3;
                dp_min[1] = Math.min(Math.min(beforeLeftMin, beforeRightMin), dp_min[1]) + a2;
            }
        }

        System.out.print(Arrays.stream(dp_max).max().getAsInt() + " ");
        System.out.println(Arrays.stream(dp_min).min().getAsInt());
    }
}
