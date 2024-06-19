package cotest.backtracking.연산자끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] operator;
    static int N;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,num[0]);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int index, int result) {
        if(index == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for(int i=0; i<4; i++) {
            if(operator[i]>0) {
                operator[i]--;
                switch(i) {
                    case 0:
                        dfs(index+1, result + num[index]);
                        break;
                    case 1:
                        dfs(index+1, result - num[index]);
                        break;
                    case 2:
                        dfs(index+1, result * num[index]);
                        break;
                    case 3:
                        dfs(index+1, result / num[index]);
                        break;
                }
                operator[i]++;
            }


        }
    }

}


