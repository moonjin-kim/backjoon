package cotest.backtracking.스타트와링크_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] team;
    static int[] visited;
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        team = new int[N+1][N+1];
        visited = new int[N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 0);

        System.out.println(min);
    }

    public static void dfs(int idx, int count) {
        if(count == N / 2) {
            sum();
            return;
        }

        for(int i = idx; i <= N; i++){
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i+1, count+1);
                visited[i] = 0;
            }
        }
    }

    public static void sum() {
        int team_start = 0;
        int team_link = 0;

        for(int i = 1; i <= N-1; i++){
            for(int j = i+1; j <= N; j++){
                if(visited[i] == 1 && visited[j] == 1){
                    team_start += team[i][j];
                    team_start += team[j][i];
                } else if(visited[i] == 0 && visited[j] == 0) {
                    team_link += team[i][j];
                    team_link += team[j][i];
                }
            }
        }
        int val = Math.abs(team_link - team_start);
        if(val == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(val, min);
    }
}
