package day19.drink20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double answer = 0;

        double[] nums = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        for(int i =0; i<N; i++) {
            double num = Double.parseDouble(st.nextToken());
            nums[i] = num;
            max = Math.max(num, max);
        }

        for(int i=0; i < N; i++) {
            if(nums[i] == max) {
                answer += nums[i];
            } else {
                answer += nums[i] / 2.0;
            }
        }

        System.out.println(answer);
    }
}
