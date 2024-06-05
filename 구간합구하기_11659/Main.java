package cotest.누적합.구간합구하기_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] data = new int[N+1];
        st = new StringTokenizer(br.readLine());
        data[0] = 0;
        for(int i=1; i<N+1; i++) {
            data[i] = data[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(data[end] - data[start-1]);
        }
    }
}
