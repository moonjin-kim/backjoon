package cotest.two_pointer.소수의_연속합_1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] decimal = eratos(N);
        int count = 0;

        int start = 0;
        int sum = 0;
        for(int end=0; end < decimal.length; end++) {
            sum += decimal[end];
            while(sum >= N) {
                if(sum == N) {
                    count++;
                }
                sum -= decimal[start++];
            }
        }

        System.out.println(count);
    }

    private static int[] eratos(int num) {
        boolean[] data = new boolean[num+1];
        for(int i = 2; i < num+1; i++) {
            data[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (data[i]) {
                for (int j = i * i; j <= num; j+=i) {
                    data[j] = false;
                }
            }
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < num+1; i++) {
            if(data[i]){
                temp.add(i);
            }
        }

        return temp.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
