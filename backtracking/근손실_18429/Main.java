package cotest.backtracking.근손실18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,500);

        System.out.println(answer);
    }

    static public void dfs(int i, int weight) {
        if (i == N) {
            answer++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visited[j] && weight + array[j] - M >= 500) {
                visited[j] = true;
                dfs(i+1, weight + array[j] - M);
                visited[j] = false;
            }
        }
    }
}
