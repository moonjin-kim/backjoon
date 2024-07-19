package cotest.bfs.로봇청소기_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int height;
    static int width;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] area;
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[height][width];
        visited = new boolean[height][width];
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int dic = Integer.parseInt(st.nextToken());
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Node(start,end,dic));

        System.out.println(answer);
    }

    static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(!visited[cur.y][cur.x]) {
                answer++;
                visited[cur.y][cur.x] = true;
            }

            if(isClean(cur)) {
                int backDic = (cur.dic + 2) % 4;
                int backX = cur.x + dx[backDic];
                int backY = cur.y + dy[backDic];
                if(area[backY][backX] == 0) {
                    queue.add(new Node(backY,backX, cur.dic));
                } else {
                    return;
                }
            } else {
                int nextDic = (cur.dic + 3) % 4;
                int nx = cur.x + dx[nextDic];
                int ny = cur.y + dy[nextDic];
                if(area[ny][nx] == 0 && !visited[ny][nx]) {
                    queue.add(new Node(ny,nx,nextDic));
                } else {
                    queue.add(new Node(cur.y,cur.x,nextDic));
                }
            }
        }
    }

    static boolean isClean(Node node) {
        int cx = node.x, cy = node.y;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(area[ny][nx] == 0 && !visited[ny][nx]) count++;
        }

        if(count == 0) return true;
        return false;
    }

    static class Node {
        int x;
        int y;
        int dic;
        Node(int y, int x, int dic) {
            this.x = x;
            this.y = y;
            this.dic = dic;
        }
    }
}
