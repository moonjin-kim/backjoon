package day21.rope2217;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] ropes = new int[n];

        for(int i=0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, ropes[i] * (n-i));
        }

        System.out.println(max);
    }
}
