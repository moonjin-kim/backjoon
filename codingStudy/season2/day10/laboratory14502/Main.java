package middle.day10.laboratory14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};
    static int n,m;
    static int originalMap[][];
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(min);
    }

    static void dfs(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i=0;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(cnt + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int copyMap[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        Queue<Node> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(originalMap[i][j] == 2) {
                    q.add(new Node(j,i));
                }
            }
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            for(int i=0; i<4; i++) {
                int nx = cx + DIRECTION_X[i];
                int ny = cy + DIRECTION_Y[i];
                if(
                        nx >= 0 &&
                                nx < m &&
                                ny >= 0 &&
                                ny < n &&
                                copyMap[ny][nx] == 0) {
                    q.add(new Node(nx,ny));
                    copyMap[ny][nx] = 2;
                }
            }
        }
        findSafeZone(copyMap);
    }

    static void findSafeZone(int[][] map) {
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }
        }
        min = Math.max(min,count);
    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
