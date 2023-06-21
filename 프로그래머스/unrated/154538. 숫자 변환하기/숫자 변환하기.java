import java.util.*;
import java.io.*;

class Solution {
    static int cnt;
    static int add;
    static int limit;
    static boolean flag;
    static boolean[] visited;
    static void BFS(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int n = queue.poll();
                if(n == limit) {
                    flag = true; break;
                }
                
                if(n + add <= limit && !visited[n + add]) {
                    queue.add(n + add); visited[n + add] = true;
                }
                if(n * 2 <= limit && !visited[n * 2]){
                    queue.add(n * 2); visited[n * 2] = true;
                }
                if(n * 3 <= limit && !visited[n * 3]){
                    queue.add(n * 3); visited[n * 3] = true;
                }
            }
            if(flag) break;
            cnt++;
        }
    }
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y+1];
        add = n;
        limit = y;
        
        BFS(x);
        
        return flag ? cnt : -1;
    }
}