import java.util.*;

class Solution {
    
    public int solution(int[] orders) {
        int answer = 0;
        
        int mainConveyorSeq = 1;
        Stack<Integer> subConveyor = new Stack<>();
        
        
        for(int order : orders){
            while(true){
                if(!subConveyor.isEmpty() && subConveyor.peek() == order){
                    answer++;
                    int test = subConveyor.pop();
                    break;
                }
                else if(mainConveyorSeq < order){
                    subConveyor.add(mainConveyorSeq++);
                }else if(mainConveyorSeq == order){
                    answer++;
                    mainConveyorSeq++;
                    break;
                }else {
                    return answer;
                }
            }
            
        }
        return answer;
    }
}