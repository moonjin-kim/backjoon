package day17.sum2559;

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

        int[] num = new int[N];
        int max = -Integer.MAX_VALUE;

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < M; i++) {
            sum += num[i];
        }
        max = Integer.max(sum,max);

        for(int i=0; i< N - M; i++) {
            sum -= num[i];
            sum += num[M+i];

            max = Integer.max(sum,max);
        }

        System.out.println(max);
    }
}
