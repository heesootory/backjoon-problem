import java.util.*;

class Solution {
    static double[] mulArr = {1.0, 2.0, 3/2.0, 4/3.0, 1/2.0, 3/4.0, 3/2.0};
    public long solution(int[] weights) {
        long answer = 0;
        
        // Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(double i : weights) map.put(i, map.getOrDefault(i, 0) + 1);
        
        System.out.print(map.get(100.0));
        
        for(int i = 1000; i >= 100; i--){
            for(double d : mulArr){
                double key = i * d;     // 짝 몸무게
                double n = map.getOrDefault((double)i, 0);     // 현재 몸무게에 해당하는 사람들
                
                if(d == 1.0 && n != 0) n--;
                answer += map.getOrDefault(key, 0) * n;
                
            }
            // double curr = i * 1.0;
            // map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        return answer/2;
    }
}