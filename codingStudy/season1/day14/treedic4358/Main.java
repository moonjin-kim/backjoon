package day14.treedic4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tree;
        TreeMap<String, Integer> map = new TreeMap<>();
        double cnt = 0;
        while((tree = br.readLine()) != null) {
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for(var t : map.entrySet()) {
            sb.append(t.getKey())
                    .append(" ")
                    .append(String.format("%.4f",t.getValue() / cnt * 100))
                    .append("\n");
        }
        System.out.println(sb);
    }
}
