package cotest.sort.나이순정렬_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Node(age, name));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // 오름차순
                return o1.age - o2.age;
            }
        });

        for (Node node : list) {
            System.out.println(node.age + " " + node.name);
        }

    }

    static class Node{
        int age;
        String name;

        Node(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}

