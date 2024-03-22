package middle.day4.tired22864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long tired = 0;
        long work = 0;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i =0; i < 24; i++) {
            if(tired + a > m) {
                tired = Math.max(0, tired-c);
                continue;
            }
            tired += a;
            work += b;
        }

        System.out.println(work);
    }
}
