package day2.UnHeard1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int unHeardCount = Integer.parseInt(st.nextToken());
        int unSeeCount = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> unHeardList = new ArrayList<>();

        for(int i = 0; i < unHeardCount; i++) {
            set.add(br.readLine());
        }

        for(int i =0; i < unSeeCount; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                unHeardList.add(name);
            }
        }

        Collections.sort(unHeardList);
        System.out.println(unHeardList.size());
        for(String person : unHeardList) {
            System.out.println(person);
        }
    }
}
