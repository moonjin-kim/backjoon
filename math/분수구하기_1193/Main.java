package cotest.math.분수구하기_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 1;
        while(N - i > 0) {
            N = N - i;
            i++;
        }

        if(i % 2 == 0) {
            System.out.print(N);
            System.out.print("/");
            System.out.print(i-N + 1);
        } else {
            System.out.print(i-N + 1);
            System.out.print("/");
            System.out.print(N);
        }
    }
}
