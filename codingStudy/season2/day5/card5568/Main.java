package middle.day5.card5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static HashSet<String> set = new HashSet<>(); //중복 여부 체크
    static int n;
    static int k;
    static boolean[] visited;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        //n개의 카드 중에 몇 번째 카드를 선택했는지 여부 파악
        visited = new boolean[n]; //전부 선택하지 않음으로 초기화
        //카드 종류
        cards = new int[n];

        //카드 등록
        for(int i=0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        //dfs
        for(int i=0; i < n; i++) { //0부터 n까지 반복하면서 선택하는 경우 확인
            visited[i] = true; //선택
            dfs(String.valueOf(cards[i]),1); //dfs
            visited[i] = false; //선택 안함
        }

        System.out.println(set.size());
    }

    public static void dfs(String num, int count) {
        if(count == k) { //선택 개수가 k개이면 set에 저장후 dfs종료
            set.add(num);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(num + cards[i],count+1);
                visited[i] = false;
            }
        }
    }
}
