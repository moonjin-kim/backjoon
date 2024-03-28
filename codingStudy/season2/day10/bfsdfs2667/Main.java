package middle.day10.bfsdfs2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] DIRECTION_X = {0,0,1,-1};
    static int[] DIRECTION_Y = {1,-1,0,0};
    static int n;
    static int[][] houses;
    static int count = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int answer = 0;

        houses = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n;i++) {
            String data = br.readLine();
            for(int j=0; j<n; j++) {
                houses[i][j] = data.charAt(j) - '0';
            }
        }

        for(int i=0; i<n;i++) {
            for(int j=0; j<n; j++) {
                if(houses[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    count = 0;
                    dfs(new Node(j,i));
                    list.add(count);
                }
            }
        }

        System.out.println(answer);
        Collections.sort(list);
        for(int data : list) {
            System.out.println(data);
        }
    }

    static void dfs(Node node) {
        visited[node.y][node.x] = true;
        count++;

        for(int i=0; i<4; i++) {
            int nx = node.x + DIRECTION_X[i];
            int ny = node.y + DIRECTION_Y[i];
            if(
                    nx >= 0 &&
                            nx < n &&
                            ny >= 0 &&
                            ny < n &&
                            !visited[ny][nx] &&
                            houses[ny][nx] == 1) {
                dfs(new Node(nx,ny));
            }
        }
    }

    static void bfs(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        visited[node.y][node.x] = true;
        int count = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            count++;
            for(int i=0; i<4; i++) {
                int nx = cx + DIRECTION_X[i];
                int ny = cy + DIRECTION_Y[i];
                if(
                        nx >= 0 &&
                                nx < n &&
                                ny >= 0 &&
                                ny < n &&
                                !visited[ny][nx] &&
                                houses[ny][nx] == 1) {
                    q.add(new Node(nx,ny));
                    visited[ny][nx] = true;
                }
            }
        }

        list.add(count);

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
