class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] match = new int[n+1][n+1];
        
        for(int [] result : results) {
            int userA = result[0];
            int userB = result[1];
            match[userA][userB] = 1;
        }
        
        for(int i=1;i<=n;i++) {
            for(int j=1; j<=n; j++) {
                for(int z=1; z<=n; z++) {
                    if(match[j][i] == 1 && match[i][z] == 1) match[j][z] =1;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            int game = 0;
            for(int j=1;j<=n;j++) {
                if(match[i][j]==1 | match[j][i] == 1) game++;
            }
            
            if(game == n-1) answer++;
        }
        
        return answer;
    }
}