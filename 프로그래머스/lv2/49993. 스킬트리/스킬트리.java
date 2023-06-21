import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees){
            String str = "";
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(skill.indexOf(c) > -1) str += c;
            }
            boolean flag = true;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(skill.indexOf(c) != str.indexOf(c)) flag = false;
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}