package day18.girl16165;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String[]> team = new HashMap<String, String[]>();
        HashMap<String, String> girl = new HashMap<String, String>();

        for(int i=0; i<N; i++) {
            String teamName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            String[] member = new String[memberCount];
            for(int j=0; j<memberCount; j++) {
                String name = br.readLine();
                member[j] = name;
                girl.put(name,teamName);
            }
            Arrays.sort(member);
            team.put(teamName, member);
        }

        for(int i=0; i<M; i++) {
            String question = br.readLine();
            int option = Integer.parseInt(br.readLine());

            if(option == 0) {
                for (String s : team.get(question))
                    bw.write(s + "\n");
            } else {
                bw.write(girl.get(question) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
