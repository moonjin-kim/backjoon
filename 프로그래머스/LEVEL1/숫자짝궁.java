import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder("");
        int[] XCount = new int[10];
        int[] YCount = new int[10];
        
        for(String x : X.split("")){
            XCount[Integer.parseInt(x)]++;
        }
        
        for(String y : Y.split("")){
            YCount[Integer.parseInt(y)]++;
        }
        
        for(int i=9; i>=0; i--){
            while(XCount[i] > 0 && YCount[i] > 0){
                sb.append(i);
                
                XCount[i]--;
                YCount[i]--;
            }
        }
        String answer = sb.toString();
        
        if(answer.equals("")){
            return "-1";
        }else if(answer.replaceAll("0","").isEmpty()){
            return "0";
        }
        
        return answer;
    }
}