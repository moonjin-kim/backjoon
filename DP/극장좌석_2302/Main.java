package cotest.dp.극장좌석_2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fib = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열 arr의 길이
        int vip = Integer.parseInt(br.readLine());
        int[] vips = new int[vip+2];
        vips[0] = 0;
        vips[vip+1] = n+1;
        for (int i = 1; i <= vip; i++) {
            vips[i] = Integer.parseInt(br.readLine());
        }

        makeFibonacci();

        long answer = 1;
        for (int i = 1; i <= vip + 1; i++) {
            int diff = vips[i] - vips[i-1] - 1;
            answer *= fib[diff];
        }

        System.out.println(answer);
    }

    static public void makeFibonacci() {
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= 40; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
    }
}
