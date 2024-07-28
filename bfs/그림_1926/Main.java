package cotest.bfs.그림_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] painting;
    static boolean[][] visited;
    static int max = 0;
    static int count = 0;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        painting = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                painting[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (painting[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));

        int size = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();


            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && painting[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }

        max = Math.max(max, size);
        count++;
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
