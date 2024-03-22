package day6.gold6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] isNotPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        makePrime(1000000);

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break; //0 출력시 종료;

            if(num == 6) sb.append("6 = 3 + 3\n");

            for(int i = 3; i < num / 2; i += 2) {
                if(!isNotPrime[i] && !isNotPrime[num-i]) {
                    sb.append(num + " = " + i + " + " + (num-i) + "\n");
                    break;
                }
            }


        }
        System.out.println(sb);
    }

    public static void makePrime(int N) {
        isNotPrime = new boolean[N+1];

        if(N < 2) return;

        isNotPrime[0] = isNotPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {

            if(isNotPrime[i]) continue;

            for(int j = i * i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}
