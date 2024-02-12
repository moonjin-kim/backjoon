package day1.numSum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        String num = sc.next();
        int sum = 0;

        for(int i=0; i < len; i++) {
            sum += Character.getNumericValue(num.charAt(i));
        }

        System.out.println(sum);
    }
}
