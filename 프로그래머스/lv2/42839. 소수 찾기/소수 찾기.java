import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static boolean[] visited;
    static int[] ans;
    static List<Integer> list;
    
    static boolean era(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static void perm(int idx, int limit){
        if(idx == limit){
            int sum = 0;
            int mul = 1;
            for(int i = idx-1; i >= 0; i--){
                sum += ans[i] * mul;
                mul *= 10;
            }
            if(!list.contains(sum)) list.add(sum);
            
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            ans[idx] = arr[i];
            perm(idx + 1, limit);
            visited[i] = false;
            
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        
        arr = new int[len];
        visited = new boolean[len];
        list = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            arr[i] = (int)numbers.charAt(i) - 48;
        }
        
        for(int i = 1; i <= len; i++){
            ans = new int[i];
            perm(0, i);
        }
        
        for(int i = 0; i < list.size(); i++){
            if(era(list.get(i)) && list.get(i) != 0 && list.get(i) != 1) answer++;
        }
        
        return answer;
    }
}