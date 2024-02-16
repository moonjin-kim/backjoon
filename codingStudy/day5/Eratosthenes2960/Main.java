package day5.Eratosthenes2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] removed = new boolean[N + 1];
        int count = 0;

        //낮은 숫자부터 조사
        for(int i = 2; i <= N; i++) {
            int n = i;
            //i의 배수 제거
            while(n <= N) {
                if(!removed[n]) {
                    count++;
                    removed[n] = true;
                    if(count == K) {
                        System.out.println(n);
                        System.exit(0);
                    }
                }
                n += i;
            }
        }

    }
}
