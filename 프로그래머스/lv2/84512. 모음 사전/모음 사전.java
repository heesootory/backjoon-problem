import java.io.*;
import java.util.*;

class Solution {
    static char[] str;
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static int len;
    static int cnt;
    static boolean end;
    
    static void dfs(int idx, String word){
        System.out.println(Arrays.toString(str)+" "+end+" "+cnt);
        cnt++;
        
        if(idx == len){
            boolean flag = true;
            for(int i = 0; i < len; i++){
                if(word.charAt(i) != str[i]) {
                    flag = false; break;
                }
            }
            if(flag) end = true;
        }
        
        if(idx == 5) return;
        if(end) return;
        
        
        
 
        
        for(int i = 0; i < 5; i++){
            str[idx] = words[i];
            dfs(idx + 1, word);
            if(end) return;
        }
    
    }
    
    public int solution(String word) {
        len = word.length();
        str = new char[5];
        dfs(0, word);
        
        return cnt-1;
    }
}