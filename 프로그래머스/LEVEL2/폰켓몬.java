import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int seleteCount = nums.length /2; //선택해야할 포켓몬 수
        
        //포켓몬의 종류 수
        int poketMonTypes = Arrays
            .stream(nums)
            .distinct()
            .toArray().length;
        
        int answer = 0;
        
        answer = poketMonTypes;
        if(poketMonTypes > seleteCount){
            answer = seleteCount;
        }
        
        return answer;
    }
}