import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();    
    
    public String[] solution(String[] files) {
        int len = files.length;
        String[] answer = new String[len];
        
        for(int i = 0; i < files.length; i++) list.add(files[i]);
        
        Collections.sort(list, new Comparator<String>(){
            
            @Override
            public int compare(String s1, String s2){
                String s1_head = s1.split("[0-9]+")[0].toLowerCase();
                String s2_head = s2.split("[0-9]+")[0].toLowerCase();
                
                if(s1_head.equals(s2_head)){
                    String s1_number = "";
                    String s2_number = "";
                    for(int i = 0; i < s1.length(); i++){
                        if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                            s1_number += s1.charAt(i);
                            if(i < s1.length()-1 && (s1.charAt(i+1) < '0' || s1.charAt(i+1) > '9')) break;
                        }
                    }
                    for(int i = 0; i < s2.length(); i++){
                        if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                            s2_number += s2.charAt(i);
                            if(i < s2.length()-1 && (s2.charAt(i+1) < '0' || s2.charAt(i+1) > '9')) break;
                        }
                    }
                    return Integer.parseInt(s1_number) - Integer.parseInt(s2_number);
                }
                else return s1_head.compareTo(s2_head);
            }
            
        });
        
        for(int i = 0; i < len; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}