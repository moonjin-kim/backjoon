package day5.Factorial1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int div = 10;
        int count = 0;
        int answer = 1;

        for(int i = 1; i <= num; i++) {
            answer *= i;
            System.out.println(answer);

            while(answer % div == 0) {
                count++;
                answer = answer / div;
            }
            answer = answer % 1000;
        }


        System.out.println(count);
    }
}
