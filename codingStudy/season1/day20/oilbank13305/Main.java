package day20.oilbank13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        long answer = 0;
        long[] distance = new long[city-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<city-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        long minOilPrice = 1000000000;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<city-1; i++) {
            long price = Long.parseLong(st.nextToken());
            if(minOilPrice > price) {
                minOilPrice = price;
            }
            answer += minOilPrice * distance[i];
        }

        System.out.println(answer);
    }
}
