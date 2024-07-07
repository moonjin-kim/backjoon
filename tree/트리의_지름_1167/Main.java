package cotest.tree.트리의지름_1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node> nodes[];
    static boolean[] visited;
    static int max;
    static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) nodes[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int value = Integer.parseInt(st.nextToken());
                nodes[from].add(new Node(to,value));
            }
        }

        visited = new boolean[N+1];
        dfs(1,0);

        visited = new boolean[N + 1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    public static void dfs(int num, int value){
        if(value > max) {
            max = value;
            maxNode = num;
        }

        visited[num] = true;
        for(Node node : nodes[num]){
            if(!visited[node.link]){
                dfs(node.link, value + node.value);
            }
        }
    }

    static class Node{
        public int link;
        public int value;

        public Node(int link, int value){
            this.link = link;
            this.value =value;
        }
    }
}
