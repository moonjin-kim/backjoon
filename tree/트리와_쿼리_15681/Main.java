package cotest.tree.트리와_쿼리15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<ArrayList<Integer>> graph;
    static ArrayList<Integer>[] tree;
    static int N;
    static int R;
    static int Q;
    static int parent[], size[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        size = new int[N+1];

        graph = new ArrayList<>();
        tree = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        for (int i = 1; i <= Q; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(size[a]);
        }
    }

    public static void makeTree(int node, int p) {
        for(int n: graph.get(node)) {
            if (n != p) {
                tree[node].add(n);
                parent[n] = node;
                makeTree(n, node);
            }
        }
    }

    public static void countSubtreeNodes(int curNode) {
        size[curNode] = 1;

        for(int n: tree[curNode]) {
            countSubtreeNodes(n);
            size[curNode] += size[n];
        }
    }

}
