package day15.streaming19583;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/gimmunjin/Downloads/boot-source-20230228 (2)/start/coding/src/day15/streaming19583/text.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int startTime = timeToInt(st.nextToken());
        int endTime = timeToInt(st.nextToken());
        int stopTime = timeToInt(st.nextToken());

        String log = null;

        int count = 0;
        HashSet<String> set = new HashSet<>();
        while((log = br.readLine()) != null) {
            st = new StringTokenizer(log);
            int logTime = timeToInt(st.nextToken());
            String nickname = st.nextToken();

            if(logTime <= startTime) {
                set.add(nickname);
            } else if (logTime >=endTime && logTime <= stopTime) {
                if(set.contains(nickname)) {
                    set.remove(nickname);
                    count++;
                }
            }
        }

        System.out.println(count);
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }

    public static int timeToInt(String time) {
        String[] times = time.split(":");

        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}