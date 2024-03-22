package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int answer = 0;
        int max5Coin = money / 5;
        for(int i = max5Coin; i >= 0; i--) {
            int remainingCoins = money - 5 * i;
            if(remainingCoins % 2 == 0) {
                answer = i + remainingCoins / 2;
                System.out.println(answer);
                System.exit(0);
            }
        }

        System.out.println(-1);
    }
}
