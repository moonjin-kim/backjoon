package cotest.sort.merge_24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int[] sorted;
    static int M = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        sorted = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, N-1);

        System.out.println(-1);
    }

    static void merge_sort(int[] arr, int left, int right) {
        if(count > M) return;
        if(left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);
            merge_sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

    }

    static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        while (j <= right) {
            sorted[k++] = arr[j++];
        }

        i = left;
        k = 0;
        while (i <= right) {
            count++;
            if(count == M) {
                System.out.println(sorted[k]);
                System.exit(0);
            }
            arr[i++] = sorted[k++];
        }
    }
}
