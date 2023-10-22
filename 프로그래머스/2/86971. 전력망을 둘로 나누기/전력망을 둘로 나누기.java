import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] adjList;
    static int min = Integer.MAX_VALUE;
    
    static int dfs(int num, boolean[] visited){
        int count = 1;
        visited[num] = true;
        
        for(int i : adjList[num]){
            if(!visited[i]){
                count += dfs(i, visited);
            }
        }
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        
        // 양방향 인접리스트 생성.
        adjList = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) adjList[i] = new ArrayList<>();
        
        // 양방향 경로 입력.
        for(int i = 0; i < wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            adjList[start].add(end);
            adjList[end].add(start);
        }
        
        // 경로를 하나씩 제외하면서 송전탑 그룹의 차이(최소) 구하기.
        for(int i = 0; i < wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            // 경로 하나 지우기.
            adjList[start].remove(Integer.valueOf(end));
            adjList[end].remove(Integer.valueOf(start));
            
            // dfs 탐색.
            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(1, visited);
            
            // 송전탑의 갯수 차이 최솟값 구하기.
            int diff = Math.abs((n - cnt) - cnt);
            min = Math.min(min, diff);
            
            // 지웠던 경로 다시 추가.
            adjList[start].add(end);
            adjList[end].add(start);
        }
        
        return min;
    }
}