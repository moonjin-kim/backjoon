package day5.Palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if(num == 1) num = 2;

        for(int i = num+1; ; i++) {
            if(isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                System.exit(0);
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

    public static boolean isPalindrome(int n) {
        StringBuilder sb = new StringBuilder(n + "");
        if(!sb.toString().equals(sb.reverse().toString()))
            return false;
        return true;
    }
}
