package day4.GCDHCF2609;

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

        int gcdNum = gcd(num1,num2);
        System.out.println(gcdNum);
        System.out.println(num1*num2/gcdNum);
    }

    public static int gcd(int num1, int num2) {
        int tmp,n;

        if(num1 < num2) {
            tmp = num1;
            num1 =  num2;
            num2 = tmp;
        }

        while(num2!=0) {
            n = num1 % num2;
            num1 = num2;
            num2 = n;
        }

        return num1;
    }

}
