import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] boards;
    static int min = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boards = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String board = br.readLine();
            for (int j = 0; j < m; j++) {
                if(board.charAt(j) == 'W') {
                    boards[i][j] = true;
                }
            }
        }

        int N_row = n - 7;
        int M_col = m - 7;
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i,j);
            }
        }
        System.out.println(min);

    }

    static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean cur = boards[x][y];

        for(int i = x; i < end_x; i++) {
            for(int j = y; j < end_y; j++) {
                if(boards[i][j] != cur) {
                    count++;
                }

                cur = !cur;
            }

            cur = !cur;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }

}