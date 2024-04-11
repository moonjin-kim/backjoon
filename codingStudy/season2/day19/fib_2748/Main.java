package middle.day19.fib_2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] fib = new long[n+1];

        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i < n+1; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(fib[n]);
    }
}
