package day17.sushi2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int max =0;

        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int [] check = new int[d+1];
        int count=0;

        for(int i=0; i<k; i++) {
            if(check[sushi[i]] == 0)  count++;
            check[sushi[i]]++;
        }

        max = count;
        for(int i=0; i < N; i++) {
            if(max <= count) {
                if(check[c] == 0) max = count + 1;
                else max = count;
            }

            if(check[sushi[i]] == 1) count--;
            check[sushi[i]]--;

            int lastSushi = sushi[(i + k) % N];
            if(check[lastSushi] == 0) count++;
            check[lastSushi]++;
        }

        System.out.println(max);
    }
}
