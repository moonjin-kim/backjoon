package cotest.정렬.좌표압축_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        PriorityQueue<Node> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            que.add(new Node(Integer.parseInt(st.nextToken()), i));
        }

        int count = -1;
        int min = Integer.MIN_VALUE;
        while(!que.isEmpty()) {
            Node node = que.poll();
            if(node.n > min) {
                min = node.n;
                count++;
            }
            arr[node.idx] = count;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    static class Node implements Comparable<Node>{
        int n;
        int idx;
        public Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.n-o.n;
        }
    }
}
