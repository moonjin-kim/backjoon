package day4.IsPrime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        for(int i = num1; i <= num2; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(int n) {
        if(n<=1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }

}
