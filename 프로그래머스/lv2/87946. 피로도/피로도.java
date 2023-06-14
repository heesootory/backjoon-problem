import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int ans;
    
    static void dfs(int idx, int[][] duns, int energe){
        ans = Math.max(ans, idx);
        
        for(int i = 0; i < duns.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            if(energe >= duns[i][0]) {
                dfs(idx + 1, duns, energe - duns[i][1]);
            }
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        
        return ans;
    }
}