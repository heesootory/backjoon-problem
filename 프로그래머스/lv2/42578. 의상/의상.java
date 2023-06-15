import java.io.*;
import java.util.*;

class Solution {
    static String[] arr;
    static int len;
    static HashMap<String, Integer> map;
    static ArrayList<String> keyList;
    static String[] str_arr;
    static int ans;

    public int solution(String[][] clothes) {
        ans = 1;
        map = new HashMap<>();
        keyList = new ArrayList<>();
        
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }else{
                map.put(clothes[i][1], 1);
                keyList.add(clothes[i][1]);
            }
        }   
        
        for(int i = 0; i < keyList.size(); i++){
            ans *= (map.get(keyList.get(i)) + 1);
        }
        ans -= 1;
        
        return ans;
    }
}