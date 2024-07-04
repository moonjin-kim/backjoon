package cotest.누적합.상호작용_16139;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] memos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int len = str.length();
        memos = new int[len+1][26];
        memos[1][str.charAt(0)-'a']++;
        for (int i = 1; i < len; i++) {
            int idx = str.charAt(i-1)-'a';
            for(int j=0;j<26;j++) {
                //알파벳의 이전 누적 합
                int before = memos[i-1][j];
                //알파벳과 탐색 중인 문자가 같으면 이전값+1, 아니면 이전값과 같음
                memos[i][j]=j==idx?before+1:before;
            }
        }
        int q = Integer.parseInt(br.readLine());

        //문제 읽기
        StringTokenizer st;
        for(int i=0;i<q;i++) {
            st=new StringTokenizer(br.readLine());
            //문제 문자
            int idx=st.nextToken().charAt(0)-'a';
            //시작점
            int start=Integer.parseInt(st.nextToken())+1;
            //끝점
            int end=Integer.parseInt(st.nextToken())+1;
            //끝점의 누적합 - 시작점 바로 이전의 누적합 = 구간의 문자 반복값
            bw.append((memos[end][idx]-memos[start-1][idx])+"\n");
        }
        bw.close();
        br.close();
    }
}
