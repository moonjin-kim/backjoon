package cotest.dp.우수마을_1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static boolean[] visited;
    static int[] populations;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        populations = new int[n + 1];
        list = new ArrayList[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int i) {
        if(visited[i]) return;

        visited[i] = true;
        dp[i][0] = 0;
        dp[i][1] = populations[i];
        for(int next: list[i]) {
            if(visited[next]) continue;
            dfs(next);

            dp[i][0] = dp[i][0] + Math.max(dp[next][0], dp[next][1]);
            dp[i][1] = dp[i][1] + dp[next][0];
        }
    }
}
