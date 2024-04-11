package middle.day22.설탕배달_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = n / 5;

        for(int i=0; i <= a; i++) {
            int remain = n - 5 * (a - i);

            if(remain % 3 == 0) {
                System.out.println(a - i + (remain / 3));
                System.exit(0);
            }
        }

        System.out.println(-1);
    }
}
