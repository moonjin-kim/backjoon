package day13.bee2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int K = 1;
        int count = 0;
        while(N - K > 0) {
            count++;
            K = K + count * 6;
        }

        System.out.println(count+1);
    }
}
