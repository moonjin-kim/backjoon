## 3075 Astromeeting

```java
package com.backjoon.back3076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, ArrayList<Graph>> graphs;
    static int[][] visited;
    static int p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int count = 0; count < T; count++){
            int target = 0;
            long min = Long.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken());
            p =  Integer.parseInt(st.nextToken());
            int q =  Integer.parseInt(st.nextToken());

            int[] nx = new int[n];
            for(int i = 0; i < n; i++){
                nx[i] = Integer.parseInt(br.readLine());
            }

            graphs = new HashMap<>();
            for(int i = 1; i <= p; i++){
                graphs.put(i, new ArrayList<>());
            }

            for(int i = 0; i < q; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graphs.get(a).add(new Graph(b,cost));
                graphs.get(b).add(new Graph(a,cost));
            }

            visited = new int[p+1][p+1];

            for(int i = 0; i < n; i++){
                bfs(nx[i]);
            }

            for(int i = 1; i <= p; i++){
                long sum = 0;
                boolean isCheck = true;
                for(int j = 0; j < n; j++){
                    int idx = nx[j];
                    if(visited[idx][i] == Integer.MAX_VALUE) {
                        isCheck = false;
                        break;
                    }
                    sum += (long) visited[idx][i] * visited[idx][i];
                }

                if(!isCheck) continue;

                if(min > sum){
                    min = sum;
                    target = i;
                }
            }

            System.out.println(target + " " + min);
        }
    }

    static void bfs(int n) {
        for(int i = 1; i <= p; i++){
            visited[n][i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(n,0));
        visited[n][n] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Graph num: graphs.get(cur.to)) {
                int next = num.to;
                int cost = num.cost;

                if(visited[n][next] <= cur.cost + cost) continue;
                visited[n][next] = cur.cost + cost;
                q.add(new Node(next,cur.cost + cost));
            }
        }
    }

    static class Graph {
        int to;
        int cost;

        public Graph(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class Node implements Comparable<Node>{
        int to, cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node){
            return this.cost - node.cost;
        }
    }
}

```
