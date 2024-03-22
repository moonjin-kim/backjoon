package middle.day2.bug15721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n,t,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int answer = solution();
        System.out.println(answer);
    }

    static int solution() {
        int p = 0, q = 0, count = 2;
        while(true) {
            //i%2 == 0 이면 뻔, i%2 == 1 이면 데기
            for(int i = 0; i < 4; i++) {
                if(i%2 == 0) {
                    p++;
                } else {
                    q++;
                }
                if (p == t && k == 0) {
                    return (p + q - 1) % n;
                }
                if( q == t && k == 1) {
                    return (p + q - 1) % n;
                }
            }
            // count 만큼 뻔 반복
            for(int i = 0; i < count; i++) {
                p++;
                if (p == t && k == 0) {
                    return (p + q -1) % n;
                }
            }
            // count 만큼 데기 반복
            for (int i =0; i < count; i++) {
                q++;
                if (q == t && k == 1) {
                    return (p + q - 1) % n;
                }
            }
            //count 번 째 반복 완료
            count++;
        }
    }
}
