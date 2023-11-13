import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int d = 0; d <= discount.length - 10; d++){
            
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < want.length; i++) map.put(want[i], number[i]);
            
            boolean flag = true;
            for(int j = d; j < d + 10; j++){
                String key = discount[j];
                if(!map.containsKey(key)) {
                    flag = false;
                    break;
                }
                map.put(key, map.get(key) - 1);
            }
            
            if(!flag) {
                continue;
            }
            
            boolean check = true;
            for(String s : want) {
                if(map.get(s) != 0) check = false;
            }
            
            if(check) answer++;
        }     
        
        
        return answer;
    }
}