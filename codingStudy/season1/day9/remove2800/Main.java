package day9.remove2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Bracket> brackets = new ArrayList<>();
    static char[] input;
    static TreeSet<String> expressions = new TreeSet<>();
    static boolean isFirst = true;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        input = br.readLine().toCharArray();
        for(int i=0; i<input.length; i++) {
            char c = input[i];
            if(c=='(') {
                stack.push(i);
            } else if(c==')') {
                brackets.add(new Bracket(stack.pop(),i));
            }
        }

        visited = new boolean[input.length];
        Arrays.fill(visited,true);
        makeExpression(0);

        for(String s: expressions) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    public static void makeExpression(int dept) {
        if(dept==brackets.size()) {
            if(isFirst) {
                isFirst = false;
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i< input.length;i++) {
                    if(visited[i]) {
                        sb.append(input[i]);
                    }
                }
                expressions.add(sb.toString());
            }
            return;
        }

        Bracket bracket = brackets.get(dept);
        visited[bracket.start] = true;
        visited[bracket.end] = true;
        makeExpression(dept+1);

        visited[bracket.start] = false;
        visited[bracket.end] = false;
        makeExpression(dept+1);

    }

    public static class Bracket {
        int start, end;

        public Bracket(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
