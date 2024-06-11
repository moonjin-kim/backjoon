package cotest.bfs.플로이드_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] graph;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, price));
        }

        for(int i=1; i<=n; i++){
            bfs(i);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public void bfs(int n){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n,0));
        visited[n][n] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for(Node node: graph[cur.x]) {
                if(!visited[n][node.x] || cur.price + node.price < map[n][node.x]) {
                    queue.offer(new Node(node.x,cur.price + node.price));
                    map[n][node.x] = cur.price + node.price;
                    visited[n][node.x] = true;
                }
            }
        }
    }
}

class Node {
    int x;
    int price;

    public Node(int x, int price) {
        this.x = x;
        this.price = price;
    }
}
