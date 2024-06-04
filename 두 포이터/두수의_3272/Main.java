package cotest.two_pointer.두수의_3272;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for(int i =0; i <N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(data);

        int start = 0;
        int end = N-1;

        while(end > start) {
            if(data[start] + data[end] == x) {
                answer++;
                end--;
            } else if (data[start] + data[end] > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer);
    }
}
