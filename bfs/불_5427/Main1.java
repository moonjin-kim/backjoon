import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[][] map;
    static int[][] visit;
    static int[] dicX = {0, 0, 1, -1};
    static int[] dicY = {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map = new char[y][x];
            visit = new int[y][x];
            for (int j = 0; j < y; j++) {
                String data = br.readLine();
                for(int k=0; k<x; k++) {
                    map[j][k] = data.charAt(k);
                }
            }
            exit(x,y);
        }

        System.out.println(sb.toString());
    }

    static void exit(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> fireQue = getFireQue(x,y);
        Node start = getStartPoint(x,y);
        visit[start.y][start.x] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            for(int k =0; k<queue.size(); k++) {
                Node cur = queue.poll();

                int curX = cur.x;
                int curY = cur.y;

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + dicX[i];
                    int nextY = curY + dicY[i];
                    if(nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                        sb.append(visit[curY][curX] + 1);
                        sb.append("\n");
                        return;
                    }

                    if(map[nextY][nextX] == '.' && visit[nextY][nextX] == 0) {
                        map[nextY][nextX] = '@';
                        queue.add(new Node(nextX, nextY));
                        visit[nextY][nextX] = visit[curY][curX] + 1;
                    }

                }
            }
            fireQue = moveFire(fireQue,x,y);
        }
        sb.append("IMPOSSIBLE\n");
        return;
    }

    static Queue<Node> moveFire(Queue<Node> queue, int x, int y) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            Node cur = queue.poll();

            for (int j = 0; j < 4; j++) {
                int nextX = cur.x + dicX[j];
                int nextY = cur.y + dicY[j];

                if(nextX < 0 || nextX >= x || nextY < 0 || nextY >= y || map[nextY][nextX] == '#' || map[nextY][nextX] == '*') {
                    continue;
                }

                if(map[nextY][nextX] == '.' || map[nextY][nextX] == '@') {
                    map[nextY][nextX] = '*';
                    queue.add(new Node(nextX, nextY));
                }
            }
        }

        return queue;
    }

    static Queue<Node> getFireQue(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == '*') {
                    queue.add(new Node(j, i));
                }
            }
        }
        return queue;
    }

    static Node getStartPoint(int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == '@') {
                    return new Node(j, i);
                }
            }
        }
        return null;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}