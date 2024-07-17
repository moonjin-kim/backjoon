package cotest.bfs.빙산_2573;

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
    static int M;
    static int answer = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];

        int max_height = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, height);
                area[i][j] = height;
            }
        }

        int time = 1;
        while(true) {
            answer = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j] && area[i][j] >= 1) {
                        remove(new Node(i, j));
                    }
                }
            }
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j] && area[i][j] >= 1) {
                        check(new Node(i, j));
                    }
                }
            }

            if(answer >= 2) {
                System.out.println(time);
                System.exit(0);
            }else if(answer == 0) {
                break;
            }
            time++;
        }

        System.out.println(0);
    }

    public static void check(Node start) {
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

                if(nx < N && nx >= 0 && ny < M && ny >= 0) {
                    if(!visited[nx][ny] && area[nx][ny] >= 1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        answer++;
    }

    public static void remove(Node start) {
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

                if(nx < N && nx >= 0 && ny < M && ny >= 0) {
                    if(!visited[nx][ny] && area[nx][ny] >= 1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    } else if(!visited[nx][ny] && area[nx][ny] == 0) {
                        area[x][y] = Math.max(area[x][y] - 1, 0);
                    }
                }
            }
        }
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
