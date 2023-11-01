import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // map에 귤 종류 - 갯수 저장
        for(int i : tangerine) map.put(i, map.getOrDefault(i, 0) + 1);
        
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int sum = 0;
        for(int i : list){
            if(sum >= k) break;
            
            sum += map.get(i);
            answer++;
        }
                
        return answer;
    }
}