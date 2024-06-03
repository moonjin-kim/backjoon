package cotest.two_pointer.부분합_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int min = S + 1;
        int sum = 0;
        int start = 0;

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int end = 0; end < N; end++) {
            sum += data[end];
            while(sum >= S && end >= start) {
                min = Math.min(min, end - start + 1);
                sum -= data[start++];
            }
        }

        if(min > S) {
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(min);
    }
}
