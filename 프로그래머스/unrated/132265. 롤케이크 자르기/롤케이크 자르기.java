import java.util.*;
import java.io.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        
        set.add(topping[0]);
        for(int i = 1; i < len; i++){
            if(map.containsKey(topping[i])) map.put(topping[i], map.get(topping[i]) + 1);
            else map.put(topping[i], 1);
        }
        if(set.size() == map.size()) answer++;
        
        for(int i = 1; i < len; i++){
            int num = topping[i];
            set.add(num);
            if(map.get(num) == 1) map.remove(num);
            else map.put(num, map.get(num)-1);
            
            if(set.size() == map.size()) answer++;
        }
        
        return answer;
    }
}