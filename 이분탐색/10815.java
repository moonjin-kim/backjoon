import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 카드의 개수
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards); // 이분탐색할 배열은 정렬되어 있어야 함.
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(find(cards, target) + " ");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int[] cards, int target) {
        int start = 0;
        int end = cards.length - 1;

        while (start <= end) {
            int mid = (start+end) / 2;
            if (cards[mid] == target) {
                return 1;
            } else if (cards[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
