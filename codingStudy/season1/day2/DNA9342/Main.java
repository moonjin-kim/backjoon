package day2.DNA9342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final String DNA_PATTERN= "[A-F]?A+F+C+[A-F]?$";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            String dna = br.readLine();
            sb.append(dna.matches(DNA_PATTERN) ? "Infected!" : "Good").append("\n");
        }

        System.out.println(sb);
    }
}
