class Solution {
    int[][] gameBoard;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] damage = new int[row+1][col+1];

        for (int[] ints : skill) {
            int power = ints[5];
            if (ints[0] == 1) {
                power = -power;
            }
            //skill[i][1]:x1, skill[i][2]:y1, skill[i][3]:x2, skill[i][4]:y2
            damage[ints[1]][ints[2]] += power;
            damage[ints[1]][ints[4] + 1] -= power;
            damage[ints[3] + 1][ints[2]] -= power;
            damage[ints[3] + 1][ints[4] + 1] += power;
        }

        // 세로로 누적합
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                damage[j+1][i] += damage[j][i];
            }
        }

        // 가로로 누적합
        for(int i = 0; i < row+1; i++){
            for(int j = 0; j < col; j++){
                damage[i][j+1] += damage[i][j];
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] + damage[i][j] > 0) answer++;
            }
        }

        return answer;
    }


}
