import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int cards1Idx = 0;
        int cards2Idx = 0;
        
        for(String word : goal){
            if(cards1Idx < cards1.length  && word.equals(cards1[cards1Idx])){
                cards1Idx += 1;
                continue;
            }else if(cards2Idx < cards2.length && word.equals(cards2[cards2Idx])){
                cards2Idx += 1;
                continue;
            }
            return "No";
        }
        
        return "Yes";
    }
}