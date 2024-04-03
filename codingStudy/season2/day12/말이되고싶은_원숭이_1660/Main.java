package middle.day12.말이되고싶은_원숭이_1660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] HORSE_MOVE_X = {1,1,-1,-1,2,2,-2,-2};
    static int[] HORSE_MOVE_Y = {2,-2,2,-2,1,-1,1,-1};
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};
    static int n,m,horse;
    static int[][] field;

    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        horse = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m][horse+1];
        field = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int a = Integer.parseInt(st.nextToken());
                field[i][j] = a;
            }
        }

        int result = bfs(new Node(0,0,horse,0));

        System.out.println(result);
    }

    static int bfs(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        visited[0][0][horse]=true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int curHorse = cur.horse;
            int move = cur.move;
            if(cx == m-1 && cy == n-1) return move;

            for(int i=0; i<4; i++) {
                int nx = cx + DIRECTION_X[i];
                int ny = cy + DIRECTION_Y[i];
                if(isMove(nx,ny) &&
                        field[ny][nx] == 0 &&
                        !visited[ny][nx][curHorse]
                ) {
                    q.add(new Node(nx,ny,curHorse,move+1));
                    visited[ny][nx][curHorse] = true;
                }
            }

            if(curHorse > 0) {
                for(int i=0; i<8; i++) {
                    int nx = cx + HORSE_MOVE_X[i];
                    int ny = cy + HORSE_MOVE_Y[i];
                    if(isMove(nx,ny) &&
                            field[ny][nx] == 0 &&
                            !visited[ny][nx][curHorse-1]
                    ) {
                        q.add(new Node(nx,ny,curHorse-1,move+1));
                        visited[ny][nx][curHorse-1] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isMove(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Node {
        int x;
        int y;
        int horse;
        int move;

        public Node(int x, int y, int horse, int move) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.move = move;
        }
    }
}
