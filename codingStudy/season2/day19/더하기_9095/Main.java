package middle.day19.더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[12];

        data[1] = 1;
        data[2] = 2;
        data[3] = 4;

        for(int i =4; i < 12; i++) {
            data[i] = data[i-1] + data[i-2] + data[i-3];
        }

        for(int i=0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(data[a]);
        }

    }
}
