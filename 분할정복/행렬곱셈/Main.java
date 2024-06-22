package cotest.분할정복.행렬곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] result;
    static int M;
    static int[][] procession1;
    static int[][] procession2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //행렬 1
        procession1 = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                procession1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //행렬 2
        st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        procession2 = new int[M][K];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++) {
                procession2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[N][K];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                System.out.print(multi(i,j) + " ");
            }
            System.out.println();
        }

    }

    static public int multi(int x, int y) {
        int sum = 0;
        for(int i = 0; i < M; i++) {
            sum += procession1[x][i] * procession2[i][y];
        }
        return sum;
    }
}
