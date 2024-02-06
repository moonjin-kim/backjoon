import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long[][] purseSum = new long[2][sequence.length];
        //[1,-1,1,...]분기
        purseSum[0][0] = sequence[0] * 1;
        //[-1,1,-1,...]분기
        purseSum[1][0] = sequence[0] * -1;
        
        long answer = Math.max(sequence[0] * 1,sequence[0] * -1);
        
        int a1 = -1;
        int a2 = 1;
        
        for(int i=1; i < sequence.length; i++) {
            purseSum[0][i] = Math.max(purseSum[0][i-1] + sequence[i] * a1,sequence[i] * a1);
            purseSum[1][i] = Math.max(purseSum[1][i-1] + sequence[i] * a2,sequence[i] * a2);
            if(answer < purseSum[0][i]) answer = purseSum[0][i];
            if(answer < purseSum[1][i]) answer = purseSum[1][i];
            a1 = -a1;
            a2 = -a2;
        }
        
        return answer;
    }
}