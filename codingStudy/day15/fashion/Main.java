package day15.fashion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String,Integer> typeMap;
    static List<String> keyList;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/Users/gimmunjin/Downloads/boot-source-20230228 (2)/start/coding/src/day15/fashion/text.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int M = Integer.parseInt(br.readLine());
            typeMap = new HashMap<>();

            for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                typeMap.put(type,typeMap.getOrDefault(type,0) + 1);
            }
            int answer = 1;
            for(int val : typeMap.values()) {
                answer *= val + 1;
            }
            System.out.println(answer - 1);
        }

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }


}
