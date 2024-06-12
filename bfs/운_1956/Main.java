package cotest.bfs.운_1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n+1][n+1];
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[start][end] = cost;
        }

        for(int k = 1; k<=n; k++) {
            for(int i = 1; i<=n; i++) {
                if(i==k) continue;
                for(int j = 1; j<=n; j++) {
                    if(i==j || k==j) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int min = INF;
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(i==j) continue;
                if(dist[i][j] != INF && dist[j][i] != INF) {
                    min = Math.min(min, dist[i][j]+dist[j][i]);
                }
            }
        }

        if(min == INF) min = -1;
        System.out.println(min);
    }

}
