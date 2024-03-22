package middle.day1.fib10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(fib(0L,1L,1,n));
        }

    }

    public static long fib(long n1, long n2, int num, int target) {
        if(num == target-1) {
            return n1 + n2;
        }

        return fib(n2,n1+n2,num+1,target);
    }
}
