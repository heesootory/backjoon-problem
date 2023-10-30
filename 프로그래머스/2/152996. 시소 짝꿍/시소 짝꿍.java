import java.util.*;

class Solution {
    static Double[] mulArr = {1.0, 2.0, 3/2.0, 4/3.0};
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i = weights.length - 1; i >= 0; i--){
            for(Double d : mulArr){
                Double key = weights[i] * d;
                if(map.containsKey(key)) answer += map.get(key);
            }
            Double curr = weights[i] * 1.0;
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        return answer;
    }
}