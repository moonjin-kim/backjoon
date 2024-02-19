package day7.stack10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String method = st.nextToken();

            if(method.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(method.equals("pop")) sb.append(stack.pop() + "\n");
            else if(method.equals("top")) sb.append(stack.top()+ "\n");
            else if(method.equals("empty")) sb.append(stack.empty()+ "\n");
            else if(method.equals("size")) sb.append(stack.size()+ "\n");
        }
        System.out.println(sb);
    }

    public static class Stack {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int idx = 0;

        public void push(int num) {
            arrayList.add(idx++,num);
        }

        public int pop() {
            if(idx > 0) {
                return arrayList.get(--idx);
            } else {
                return -1;
            }
        }

        public int size() {
            return idx;
        }

        public int empty() {
            return idx > 0 ? 0 : 1;
        }

        public int top() {
            if(idx > 0) {
                return arrayList.get(idx-1);
            } else {
                return -1;
            }
        }
    }
}
