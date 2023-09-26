import java.util.*;

class Solution {
    int MAX_LEN = 5;
    
    public int solution(String word) {
        int answer = 0;
        HashMap<Character,Integer> orderMap = new HashMap<>();
        orderMap.put('A',0);
        orderMap.put('E',1);
        orderMap.put('I',2);
        orderMap.put('O',3);
        orderMap.put('U',4);
        
        int[] weights = {781, 156, 31, 6, 1};
        
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int order = orderMap.get(c);
            answer += order * weights[i] + 1;
        }
        
        return answer;
    }
}