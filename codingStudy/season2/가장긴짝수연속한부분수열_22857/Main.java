package middle.day22.가장긴짝수연속한부분수열_22857;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            int end = i;
            int count = 0;
            int removeCount = k;

            while(end < n && removeCount >= 0) {
                if(arr[end] % 2 == 0) {
                    count++;
                } else {
                    removeCount--;
                }
                max = Math.max(max,count);
                end++;
            }
        }

        System.out.println(max);
    }
}
