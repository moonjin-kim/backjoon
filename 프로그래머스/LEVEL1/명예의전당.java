import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int k, int[] scores) {
        ArrayList<Integer> answer = new ArrayList<Integer>(); 
        
        List<Integer> hallOfFram = new ArrayList<Integer>();
        
        for(int score : scores){
            hallOfFram.add(score);
            
            Collections.sort(hallOfFram,Collections.reverseOrder());
            
            if(hallOfFram.size() > k){
                hallOfFram.remove(k);
            }
            
            answer.add(hallOfFram.get(hallOfFram.size()-1));
        }
        
        return answer;
    }
}