package day13.queue1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[M];
        for(int i = 0 ; i < M ; i++)
            temp[i] = Integer.parseInt(st.nextToken());


        for(int i=1; i<=N; i++) {
            q.add(i);
        }



        int count = 0;
        for(int i =0; i < M; i++) {
            if(check(temp[i])){
                while(q.get(0) != temp[i]) {
                    int num =q.pollFirst();
                    q.addLast(num);
                    count++;
                }
            } else {
                while(q.get(0) != temp[i]) {
                    int num =q.pollLast();
                    q.addFirst(num);
                    count++;
                }
            }

            q.poll();
        }

        System.out.println(count);
    }

    public static boolean check(int a) {
        for(int i=0; i <= q.size()/2;i++) {
            if(a == q.get(i)) return true;
        }

        return false;
    }
}
