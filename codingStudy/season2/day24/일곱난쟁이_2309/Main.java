package middle.day24.일곱난쟁이_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] smurf = new int[9];
    static int[] seven = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++) {
            smurf[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0,0);
    }

    static public void dfs(int idx,int count, int sum) {
        if(count == 7 && sum == 100) {
            printSortedSeven();
            System.exit(0);
        }

        if(idx >= 9 || count >= 7) {
            return;
        }

        for(int i = idx; i < 9; i++) {
            seven[count] = smurf[i];
            dfs(idx+1, count+1, sum + smurf[i]);
            seven[count] = 0;
        }
    }

    static public void printSortedSeven() {
        Arrays.sort(seven);
        for(int i=0;i<7; i++) {
            System.out.println(seven[i]);
        }
    }
}
