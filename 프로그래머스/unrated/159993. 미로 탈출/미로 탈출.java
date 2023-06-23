import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static char[][] map;
    static int N, M;
    static int sx, sy;
    static int ex, ey;
    static int lx, ly;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cnt;
    static boolean[][] visited;
    
    static boolean bfs(int x, int y, int a, int b){
        Queue<Pair> queue = new LinkedList<>();
        visited = new boolean[N][M];
        queue.add(new Pair(x, y));
        boolean flag = false;
        
        while(!queue.isEmpty()){
            
            int len = queue.size();
            for(int l = 0; l < len; l++){
                Pair p = queue.poll();
                if(p.x == a && p.y == b) {
                    flag = true; break;
                }
                int next_x = 0;
                int next_y = 0;
                for(int d = 0; d < 4; d++){
                    next_x = p.x + dx[d];
                    next_y = p.y + dy[d];
                    if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) continue;
                    if(visited[next_x][next_y] || map[next_x][next_y] == 'X') continue;

                    queue.add(new Pair(next_x, next_y));
                    visited[next_x][next_y] = true;
                }
            }
            if(flag) break;
            cnt++;
        }
        return flag;
    }
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        int answer = 0;
        boolean check = false;
        map = new char[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    sx = i; sy = j;
                }else if(map[i][j] == 'E'){
                    ex = i; ey = j;
                }else if(map[i][j] == 'L'){
                    lx = i; ly = j;
                }
            }
        }
        
        check = bfs(sx, sy, lx, ly);
        answer += cnt;
        cnt = 0;
        System.out.println(answer);
        if(check){
            check = bfs(lx, ly, ex, ey);
            answer += cnt;
        }
        return check ? answer : -1;
    }
}