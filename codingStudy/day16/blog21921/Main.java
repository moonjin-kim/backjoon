package day16.blog21921;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] log = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            log[i] = Integer.parseInt(st.nextToken());
        }

        //초기 방문자 수
        int sum = 0;
        int day = 1;
        for(int i=0; i<X;i++) {
            sum += log[i];
        }
        int max = sum;

        for (int i = X; i < N; i++) {
            sum += log[i] - log[i-X];
            if (max == sum) day++;
            else if (max < sum) {
                max = sum;
                day = 1;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
            System.exit(0);
        }

        System.out.println(max);
        System.out.println(day);
    }
}
