import java.io.*;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int M, N;
    static int[][] way = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
    static char[][] map;
    static ArrayList<Pair> list;
    
    static int check(){
        list = new ArrayList<>();
        int count = 0;
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                char c = map[i][j];
                if(c == '.') continue;
                int next_i = 0;
                int next_j = 0;
                int cnt = 0;
                for(int d = 0; d < 4; d++){
                    next_i = i + way[d][0];
                    next_j = j + way[d][1];
                    if(next_i >= M || next_j >= N) continue;
                    if(map[next_i][next_j] == c) cnt++;
                }
                next_i = 0; next_j = 0;
                if(cnt == 4) {
                   for(int d = 0; d < 4; d++){
                        next_i = i + way[d][0];
                        next_j = j + way[d][1];
                       boolean flag = false;
                       for(Pair p: list){
                           if(p.x == next_i && p.y == next_j) {
                               flag = true;
                               break;
                           }
                       }
                       if(flag) continue;
                        list.add(new Pair(next_i, next_j));
                        count++;
                    } 
                }
            }
        }
        return count;
    }
    
    static void change(){
        for(Pair p : list){
            System.out.println(p.x + " " + p.y);
            map[p.x][p.y] = '.';
        }
    }
    
    static void drop(){
        for(int i = M-2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                if(map[i+1][j] == '.'){
                    int a = i;
                    int b = j;
                    while(a <= M-2 && map[a+1][b] == '.'){
                        map[a+1][b] = map[a][b];
                        map[a][b] = '.';
                        a++;
                    }
                }
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m; N = n;
        
        map = new char[m][n];
        for(int i = 0; i < m; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(true){
            int total = check();
            // System.out.println(total);
            if(total <= 0) break;
            answer += total;
            change();
            drop();
            // show();
        }
        
        return answer;
    }
    
    static void show(){
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}