package day2.WhoIsWin20154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] NUM_OF_STROKE = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String charData =  br.readLine();
        int sum = 0;
        for(int i=0; i< charData.length();i++) {
            char N = charData.charAt(i);
            int num = N;
            sum += NUM_OF_STROKE[num - 65];
            sum = sum % 10;
        }

        if(sum % 2 != 0) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }
    }
}
