package cotest.other.미니게임_25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Set<String> userSet = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int ims = 0;
        for (int i = 0; i < n; i++) {
            String user = br.readLine();
            userSet.add(user);
        }

        if (game.equals("Y")) {
            System.out.println(userSet.size());
        }
        else if(game.equals("F")) {
            int count = userSet.size() / 2;
            System.out.println(count);
        }
        else if(game.equals("O")) {
            int count = userSet.size() / 3;
            System.out.println(count);
        }
    }
}
