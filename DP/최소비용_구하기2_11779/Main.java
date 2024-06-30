package cotest.dp.최소비용_구하기2_11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int min = Integer.MAX_VALUE;
    static String route = "";
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int city = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[city+1];
        dist = new int[city+1];
        for(int i = 0; i < city+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < city+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
        System.out.println(min);
        System.out.println(route.split(" ").length);
        System.out.println(route);
    }

    static private void bfs(int start, int end) {
        PriorityQueue<Route> que = new PriorityQueue<>();
        que.add(new Route(start,0,"" + start));

        while(!que.isEmpty()) {
            Route cur = que.poll();

            if(cur.x == end) {
                min = cur.cost;
                route = cur.route;
                return;
            }

            for(Node temp : graph[cur.x]) {
                if(dist[cur.x] + temp.amount < dist[temp.x]) {
                    dist[temp.x] = dist[cur.x] + temp.amount;
                    que.add(new Route(temp.x, cur.cost + temp.amount, cur.route + " " + temp.x));
                }

            }
        }
    }

}

class Node {
    int x;
    int amount;

    public Node(int x, int amount) {
        this.x = x;
        this.amount = amount;
    }
}

class Route implements Comparable<Route>{
    int x;
    int cost;
    String route;

    public Route(int x, int amount, String route) {
        this.x = x;
        this.cost = amount;
        this.route = route;
    }

    @Override
    public int compareTo(Route o) {
        // TODO Auto-generated method stub
        return cost - o.cost;
    }
}