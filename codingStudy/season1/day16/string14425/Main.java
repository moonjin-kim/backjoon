package day16.string14425;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i< N; i++) {
            String text = br.readLine();
            set.add(text);
        }

        for(int i = 0; i< M; i++) {
            String text = br.readLine();
            if(set.contains(text)) {
                count++;
            }
        }

        System.out.println(count);

    }
}
