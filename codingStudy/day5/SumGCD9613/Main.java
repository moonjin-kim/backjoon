package day5.SumGCD9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] num = new int[n];

            for(int j =0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            for(int j = 0; j < n; j++) {
                for(int k = j; k < n; k++) {
                    if(k!=j) {
                        answer += gcd(num[j],num[k]);
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
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
