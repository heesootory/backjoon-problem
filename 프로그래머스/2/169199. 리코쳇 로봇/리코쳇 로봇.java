import java.util.*;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static char[][] map;
    static int row, col;
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};    // 아래, 왼, 위, 오른
    static boolean[][] visited;
    static int cnt;
    
    static void bfs(Pair start){
        visited = new boolean[row][col];
        visited[start.x][start.y] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        
        boolean right = false;
        
        loop :
        while(!queue.isEmpty()){
            int qLen = queue.size();
            cnt++;
            
            System.out.println("aa");
                
            for(int q = 0; q < qLen; q++){
                Pair curr = queue.poll();
                
                for(int d = 0; d < 4; d++){
                    int next_x = curr.x + dir[d][0];
                    int next_y = curr.y + dir[d][1];
                    boolean mapOut = false;
                    
                    // 이동시켜봐
                    while(true){
                        if(next_x < 0 || next_y < 0 || next_x >= row || next_y >= col) {
                            next_x -= dir[d][0];
                            next_y -= dir[d][1];
                            mapOut = true;
                            break;
                        }
                        if(map[next_x][next_y] == 'D') {    
                            next_x -= dir[d][0];
                            next_y -= dir[d][1];
                            break;
                        }
                        next_x += dir[d][0];
                        next_y += dir[d][1];
                    }
                    
                    // 가능한지 확인.
                    if(map[next_x][next_y] == 'G'){
                        right = true;
                        break loop;  
                    } 
                    if(visited[next_x][next_y]) continue;
                    
                    // 갈 수 있는 곳이라면
                    visited[next_x][next_y] = true;
                    queue.add(new Pair(next_x, next_y));
                }
            }
        }
        
        if(!right) cnt = -1;
    }
    
    public int solution(String[] board) {
        row = board.length;
        col = board[0].length();
        map = new char[row][col];
        int start_x = 0;
        int start_y = 0;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                char c = board[i].charAt(j);
                map[i][j] = c;
                if(c == 'R') {
                    start_x = i;
                    start_y = j;
                }
            }
        }
        
        bfs(new Pair(start_x, start_y));
        
        return cnt;
    }
}