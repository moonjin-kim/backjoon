package day15.zoomong1940;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] ingredient = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++) {
            ingredient[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredient);

        int start = 0;
        int end = ingredient.length-1;
        int count = 0;

        while(start < end) {
            int armor = ingredient[start] + ingredient[end];
            if(armor < M) {
                start++;
            } else if (armor == M) {
                count++;
                end--;
            } else {
                end--;
            }
        }
        System.out.println(count);
    }
}
