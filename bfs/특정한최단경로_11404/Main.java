package cotest.bfs.특정한최단경로_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int[] cost;
    static boolean[] visited;
    static int MAX_NUM = 20000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cost = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        ans1 += bfs(1,v1);
        ans1 += bfs(v1,v2);
        ans1 += bfs(v2,n);

        int ans2 = 0;
        ans2 += bfs(1,v2);
        ans2 += bfs(v2,v1);
        ans2 += bfs(v1,n);

        if(ans1 >= MAX_NUM && ans2 >= MAX_NUM) ans1 = -1;
        int max = Math.min(ans1, ans2);
        System.out.println(max);
    }

    static public int bfs(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start,0));
        Arrays.fill(visited, false);
        Arrays.fill(cost, MAX_NUM);

        cost[start] = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(visited[cur.x]) continue;
            visited[cur.x] = true;

            for(Node n : graph[cur.x]){
                if(cost[n.x] > cost[cur.x] + n.cost){
                    cost[n.x] = cost[cur.x] + n.cost;
                    queue.offer(new Node(n.x,cost[cur.x] + n.cost));
                }
            }
        }

        return cost[end];
    }
}

class Node implements Comparable<Node>{
    int x;
    int cost;

    public Node(int x, int cost) {
        this.x = x;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
