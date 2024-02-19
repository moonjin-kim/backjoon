package day6.combination2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int div2 = divide2(N) - divide2(M) - divide2(N-M);
        int div5 = divide5(N) - divide5(M) - divide5(N-M);

        System.out.println(Math.min(div2,div5));
    }

    //인수분해하여 5^ 계산
    public static int divide5(int num) {
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        return count;
    }

    //인수분해하여 2^ 계산
    public static int divide2(int num) {
        int count = 0;

        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }

        return count;
    }
}
