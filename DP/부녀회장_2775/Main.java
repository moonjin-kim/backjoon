package cotest.dp.부녀회장_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        for(int i=1; i<15; i++) {
            apt[0][i] = i;
        }

        for(int floor = 1; floor < 15; floor++) {
            for(int number = 1; number < 15; number++) {
                apt[floor][number] = apt[floor][number-1] + apt[floor-1][number];
            }
        }

        for(int i = 0; i < len; i++) {
            int floor = Integer.parseInt(br.readLine());
            int number = Integer.parseInt(br.readLine());
            System.out.println(apt[floor][number]);
        }
    }
}
