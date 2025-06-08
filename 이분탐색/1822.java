import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        // 집합 A 입력 받기
        int[] A = new int[nA];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 집합 B 입력 받기
        int[] B = new int[nB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < nA; i++) {
            if (Arrays.binarySearch(B, A[i]) < 0) {
                count++;
                sb.append(A[i]).append(" ");
            }
        }

        System.out.println(count);
        if (count > 0) {
            System.out.println(sb.toString().trim());
        }
    }
}
