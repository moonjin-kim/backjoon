package cotest.dp.DSLR_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a,b)).append("\n");
        }
        System.out.println(sb);
    }

    static public String bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        q.add(new Node(a, ""));
        String result = "";
        visited[a] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.num == b) {
                result = cur.register;
                break;
            }

            int L = left(cur.num);
            int S = Sub(cur.num);
            int D = DOUBLE(cur.num);
            int R = right(cur.num);

            if(!visited[L]) {
                visited[L] = true;
                q.offer(new Node(L, cur.register + "L"));
            }
            if(!visited[S]) {
                visited[S] = true;
                q.offer(new Node(S, cur.register + "S"));
            }
            if(!visited[D]) {
                visited[D] = true;
                q.offer(new Node(D, cur.register + "D"));
            }
            if(!visited[R]) {
                visited[R] = true;
                q.offer(new Node(R, cur.register + "R"));
            }
        }

        return result;
    }

    static public int left(int n) {
        int first = n / 1000;
        int second = n % 1000 * 10;
        return first + second;
    }

    static public int right(int n) {
        int first = n / 10;
        int second = n % 10 * 1000;
        return first + second;
    }

    static public int Sub(int n) {
        if(n == 0) {
            return 9999;
        } else {
            return n - 1;
        }
    }

    static public int DOUBLE(int n) {
        return n * 2 % 10000;
    }

    static class Node {
        int num;
        String register;

        Node(int num, String register) {
            this.num = num;
            this.register = register;
        }
    }
}
