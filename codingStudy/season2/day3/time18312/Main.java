package middle.day3.time18312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int h=0; h<=n;h++) {
            for(int m=0; m<=59;m++) {
                for(int s=0;s<=59;s++) {
                    if(check(h,m,s,k))answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean check(int h, int m, int s, int k) {
        if(h/10==k||h%10==k||m/10==k||m%10==k||s/10==k||s%10==k) {
            return true;
        }
        return false;
    }

}
