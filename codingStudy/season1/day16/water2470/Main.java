package day16.water2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min=Integer.MAX_VALUE;
        int minNum = 0;
        int maxNum = 0;
        int start = 0;
        int end = N-1;

        while(start < end) {
            int sum = arr[start] + arr[end];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);

                minNum = arr[start];
                maxNum = arr[end];

                if(min == 0) break;
            }

            if(sum < 0) start++;
            else end--;
        }

        System.out.println(minNum + " " + maxNum);
    }
}
