package middle.day16.다리만들기_2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] field = new int[101][101];
    static boolean[][] isIslandCheck = new boolean[101][101];
    static int[] dicX = {1,0,-1,0};
    static int[] dicY = {0,1,0,-1};
    static int answer = 100001;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 같은 섬끼리 그룹핑
        int islandNum = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!isIslandCheck[i][j] && field[i][j] != 0){
                    dfs(i,j,islandNum);
                    islandNum++;
                }
            }
        }

        for(int i =0; i<N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        // 각 섬별로 설치할 수 있는 다리 경우 계산
        for(int i=1;i<=islandNum;i++){
            int[][] map = field.clone();
            bfs(map,i);
        }

        System.out.println(answer);

    }

    static void dfs(int y, int x, int islandNum){
        isIslandCheck[y][x] = true;
        field[y][x] = islandNum;

        for(int i=0;i<4;i++){
            int nx = x + dicX[i];
            int ny = y + dicY[i];
            if(!isMoved(nx,ny)) continue;

            if(field[ny][nx] != 0 && !isIslandCheck[ny][nx])
                dfs(ny,nx,islandNum);
        }
    }

    public static void bfs(int[][] map, int isLandNum) {
        boolean[][] check = new boolean[101][101];
        Queue<Node> q = new ArrayDeque<>();

        System.out.println();
        System.out.println(isLandNum + "섬");
        System.out.println();

        // 해당 섬을 큐에 추가
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == isLandNum){
                    q.add(new Node(i,j,0));
                    check[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i < 4; i++) {
                int nx = cur.x + dicX[i];
                int ny = cur.y + dicY[i];

                if(!isMoved(nx, ny)) continue;

                if(map[ny][nx] != isLandNum && field[ny][nx] != 0 ) {
                    answer = Math.min(answer, cur.cnt);
                    System.out.println(nx + " "+ ny + " " + "섬 = " + cur.cnt);
                } else if (map[ny][nx] == 0 && !check[ny][nx] ) {
                    System.out.println("다리 = " + cur.cnt);
                    q.add(new Node(nx,ny,cur.cnt+1));
                    check[ny][nx] = true;
                }
            }
        }

    }

    public static boolean isMoved(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Node{
        int y;
        int x;
        int cnt;
        Node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
