package day3.OrganizeFile20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> fileMap = new HashMap<>();
        int len = Integer.parseInt(br.readLine());

        for(int i=0;i < len; i++) {
            String fileName = br.readLine();
            String extension = fileName.substring(fileName.indexOf(".")+1);
            fileMap.put(extension,fileMap.getOrDefault(extension,0)+1);
        }

        List<String> keyList = new ArrayList<>(fileMap.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for(String key : keyList) {
            System.out.println(key + " " + fileMap.get(key));
        }
    }
}
