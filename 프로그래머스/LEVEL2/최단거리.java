import java.util.*;

class Solution {
    int dx[] = {0,0,-1,1};
    int dy[] = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        int maxX = maps[0].length;
        int maxY = maps.length;
        boolean[][] visited = new boolean[maxY][maxX];
        
        queue.offer(new Node(0,0,1));
        visited[0][0] = true;
        
        
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int curX = curNode.getX();
            int curY = curNode.getY();
            int curCost = curNode.getCost();
            
            if(curX == maxX-1 && curY == maxY-1){
                return curCost;
            }
            
            for(int i=0;i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && maps[nextY][nextX]  == 1 && visited[nextY][nextX] == false){
                    queue.offer(new Node(nextX,nextY,curCost+1));
                    visited[nextY][nextX] = true;
                }
            }
        }
        
        
        return -1;
    }
    
    public class Node {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
        
        public int getX(){
            return x;
        }
        
        public int getY(){
            return y;
        }
        
        public int getCost(){
            return cost;
        }
	}
}