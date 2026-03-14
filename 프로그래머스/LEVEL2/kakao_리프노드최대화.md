```java
class Solution {
    int answer = 1;
    
    public int solution(int dist_limit, int split_limit) {
        answer = 1;
        dfs(1,1,1,0,dist_limit,split_limit);
        return answer;
    }
    
    // cur- 현재 분배가능한 노드수, used - 지금까지 사용한 분배 노드 수
    // split - 현재까지의 분배도, leaf - 확정된 리프 노드 수
    void dfs(long cur, long used, long split, long leaf, int distLimit, int splitLimit) {
        if(used > distLimit) return;
        
        answer = (int)Math.max(answer, leaf + cur);
        
        for(int child = 2; child <= 3; child++) {
            long nextSplit = split * child;
            if(nextSplit > splitLimit) continue;
            
            // dept 다음 node 개수
            long nextNodes = cur * child;
            
            // 남은 분배 노드 
            long remain = distLimit - used;
            
            long nextCur = Math.min(nextNodes, remain);
            
            long nextLeaf = leaf + (nextNodes - nextCur);
            
            dfs(nextCur, used + nextCur, nextSplit, nextLeaf, distLimit, splitLimit);
        }
    }
}
```
