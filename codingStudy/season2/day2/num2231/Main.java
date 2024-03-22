package middle.day2.num2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int minNum = num.length() * 9;
        int N = Integer.parseInt(num);
        minNum = Math.max(0,N - minNum);

        for(int i = minNum; i < N; i++) {
            if(i + sumOfDigits(i) == N) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(0);
    }



    public static int sumOfDigits(int num) {
        String number = String.valueOf(num);
        int sum = 0;
        for(char n : number.toCharArray()) {
            sum += Character.getNumericValue(n);
        }

        return sum;
    }
}
