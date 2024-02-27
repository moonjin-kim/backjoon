package day12.printqueue1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < N; i++) {
            //우선 순위 큐를 만들어 높은 숫자대로 정렬하는 큐를 만듬
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            Queue<PrintJob> printJobs = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int priority = Integer.parseInt(st.nextToken());
                priorityQueue.add(priority);
                PrintJob newJob = new PrintJob(j,priority);
                printJobs.add(newJob);
            }

            int maxJob = priorityQueue.poll();
            int count = 1;

            while(true) {
                PrintJob currentJob = printJobs.poll();
                //우선순위가 다르면 큐 가장 뒤로 보냄
                if(maxJob != currentJob.priority) {
                    printJobs.add(currentJob);
                } else {
                    //현재 인덱스가 찾는 인덱스와 같으면 반복문 종료
                    if(K == currentJob.idx) {
                        break;
                    }
                    maxJob = priorityQueue.poll();
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static class PrintJob {
        int idx;
        int priority;

        public PrintJob(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
