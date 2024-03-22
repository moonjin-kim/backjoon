package day14.poketmon1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> encyclopediaNum = new HashMap<>();
        HashMap<String, Integer> encyclopediaName = new HashMap<>();
        for(int i=1; i <= N; i++) {
            String poketmon = br.readLine();
            encyclopediaNum.put(i,poketmon);
            encyclopediaName.put(poketmon,i);
        }

        for(int i=0; i < M; i++) {
            String answer = br.readLine();
            if(isNumberic(answer)) {
                sb.append(encyclopediaNum.get(Integer.parseInt(answer))).append("\n");
            } else {
                sb.append(encyclopediaName.get(answer)).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static boolean isNumberic(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
