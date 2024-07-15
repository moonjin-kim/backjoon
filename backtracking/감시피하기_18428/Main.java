package cotest.backtracking.감시피하기_18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static ArrayList<Node> students = new ArrayList<>();
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'S') students.add(new Node(i, j));
            }
        }

        dfs(0);
        System.out.println("NO");
    }

    static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(wall + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'T') {
                    q.add(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (map[nx][ny] != 'O') {
                        check[nx][ny] = true;
                        nx += dx[i];
                        ny += dy[i];
                    }else{
                        break;
                    }
                }
            }
        }

        if(checkVoid(check)) {
            System.out.println("YES");
            System.exit(0);
        }
    }

    static boolean checkVoid(boolean[][] check) {
        for (Node student : students) {
            if(check[student.x][student.y]){
                return false;
            }
        }
        return true;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
