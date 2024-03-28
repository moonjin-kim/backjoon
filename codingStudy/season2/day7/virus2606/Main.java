package middle.day7.virus2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int node[][]; // 그래프 배열
    static boolean check[]; // 방문 배열

    static int n, line;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        node = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i=0; i<line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            node[a][b] = node[b][a] =  1;
        }

        bfs(1);

        System.out.println(count-1);
    }

    public static void dfs(int start) {
        check[start] = true;
        count++;
        for(int i = 0; i <= n; i++) {
            if(node[start][i] == 1 && !check[i]) dfs(i);

        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        check[start] = true;
        while(!q.isEmpty()) {
            int a = q.poll();
            count++;

            for(int i=0;i <= n; i++) {
                if(node[a][i] == 1 && !check[i]) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
