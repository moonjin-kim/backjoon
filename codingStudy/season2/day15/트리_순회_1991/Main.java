package middle.day15.트리_순회_1991;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        tree = new int[n][2];

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A';
            for(int j=0; j<2; j++) {
                char data = st.nextToken().charAt(0);
                if(data != '.') {
                    tree[index][j] = data - 'A';
                } else {
                    tree[index][j] = -1;
                }
            }
        }

        preorder(0,bw);
        bw.write("\n");

        inorder(0,bw);
        bw.write("\n");

        postorder(0,bw);
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    public static void preorder(int x, BufferedWriter bw) throws IOException {
        bw.write((char)(x + 'A'));
        for(int i=0; i<2; i++) {
            if(tree[x][i] != -1){
                preorder(tree[x][i],bw);
            }
        }
    }

    public static void inorder(int x, BufferedWriter bw) throws IOException {
        if(tree[x][0] != -1){
            inorder(tree[x][0],bw);
        }
        bw.write((char)(x + 'A'));
        if(tree[x][1] != -1){
            inorder(tree[x][1],bw);
        }
    }

    public static void postorder(int x, BufferedWriter bw) throws IOException {
        for(int i=0; i<2; i++) {
            if(tree[x][i] != -1){
                postorder(tree[x][i],bw);
            }
        }
        bw.write((char)(x + 'A'));
    }
}
