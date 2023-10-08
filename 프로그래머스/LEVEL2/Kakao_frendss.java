import java.util.*;

class Solution {
    static boolean v[][];
    
    public int solution(int h, int w, String[] board) {
        int answer = 0;
        char copy[][] = new char[h][w];
        for(int i=0; i<h ; i++){
            copy[i] = board[i].toCharArray();
        }
        
        boolean removeStatus = true; // 블럭이 지워졌는지 여부 파악
        while(removeStatus) {
            v = new boolean[h][w];
            removeStatus = false;
            for(int i=0; i<h-1; i++){
                for(int j=0; j<w-1; j++){
                    if(copy[i][j]=='#') continue;
                    if(checkBlock(i,j,copy)){
                        v[i][j] = true;
                        v[i][j+1] = true;
                        v[i+1][j] = true;
                        v[i+1][j+1] = true;
                        removeStatus = true;
                    }
                }
            }
            answer += removeBlock(h,w,copy);
        }
        
        return answer;
    }
    
    //2 * 2 체크
    public boolean checkBlock(int curH, int curW, char[][] board){
        char ch = board[curH][curW];
        if(ch == board[curH + 1][curW] && ch == board[curH][curW + 1] && ch == board[curH +1][curW + 1] ){
            return true;
        }
        return false;
    }
    
    public int removeBlock(int h, int w,char[][] board){
        int cnt = 0;
        Stack<Character> q = new Stack<>();
        
        for(int i =0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(v[j][i]){
                    cnt++;
                }else{
                    q.add(board[j][i]);
                }
            }
            
            int idxH = h-1;
            while(!q.isEmpty()){
                board[idxH--][i] = q.pop();
            }
            
            // 빈칸 채우기
            for(int j=idxH; j>=0; j--){
                board[j][i] = '#';
            }
        }
        return cnt;
    }
}