package cotest.bfs.영역구하기_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[x][y] == 0 && !visited[x][y]) {
                    answer++;
                    bfs(x, y);
                }
            }
        }

        System.out.println(answer);
        for (int x = 0; x < answer; x++) {
            System.out.print(pq.poll() + " ");
        }

    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        int count = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
                count++;
            }
        }
        pq.add(count);
    }

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
