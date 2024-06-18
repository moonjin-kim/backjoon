package cotest.backtracking.N_Quean_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] visit;
    static int count = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            visit[depth] = i;
            if(isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for(int i = 0; i < depth; i++) {
            if(visit[i] == visit[depth]) {
                return false;
            } else if(Math.abs(depth-i) == Math.abs(visit[depth]-visit[i])) {
                return false;
            }
        }
        return true;
    }
}


