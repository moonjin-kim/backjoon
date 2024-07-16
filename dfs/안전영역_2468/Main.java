package cotest.bfs.안전영역_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] area;
    static boolean[][] visited;
    static int N;
    static int answer = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max_answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        int max_height = 0;
        int min_height = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                min_height = Math.min(min_height, height);
                max_height = Math.max(max_height, height);
                area[i][j] = height;
            }
        }

        for(int height = min_height; height <= max_height; height++) {
            answer = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && area[i][j] >= height) {
                        bfs(new Node(i, j), height);
                    }
                }
            }

            max_answer = Math.max(max_answer, answer);
        }
        System.out.println(max_answer);
    }

    public static void bfs(Node start, int height) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < N && nx >= 0 && ny < N && ny >= 0 && !visited[nx][ny] && area[nx][ny] >= height) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        answer++;
    }

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
