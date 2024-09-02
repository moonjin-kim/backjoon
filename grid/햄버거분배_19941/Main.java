package cotest.greed.햄버거분배_19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] info = br.readLine().toCharArray();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(info[i] == 'P') {
                int index = Math.max(i - m, 0);
                boolean check = false;
                for(int j = index; j < i; j++) {
                    if(info[j] == 'H') {
                        answer++;
                        info[j] = 'X';
                        check = true;
                        break;
                    }
                }

                if(!check) {
                    index = Math.min(i + m, n-1);
                    for(int j = i; j <= index; j++) {
                        if(info[j] == 'H') {
                            info[j] = 'X';
                            answer++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
