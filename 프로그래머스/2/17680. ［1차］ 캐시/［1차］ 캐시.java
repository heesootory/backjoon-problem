import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;

        Map<String, Integer> map = new HashMap<>();
        
        for(String city : cities){
            String str = city.toLowerCase();
            
            if(map.isEmpty() || !map.containsKey(str)){     // 캐시에 없을 때
                if(map.size() >= cacheSize){  // 캐시가 가득 찼을때
                    // 가장 오래된 캐시 구하기
                    int oldest = 0;
                    for(Map.Entry<String, Integer> ent : map.entrySet()){
                        int age = ent.getValue();
                        if(age > oldest) oldest = age;
                    }
                    // 가장 오래된 캐시 삭제
                    for(Map.Entry<String, Integer> ent : map.entrySet()){
                        if(ent.getValue() == oldest) {
                            map.remove(ent.getKey());
                            break;
                        }
                    }
                }    
                answer += 5;
            }else{         // 캐시에 존재할 때
                answer += 1;
            }
            
            map.put(str, 0);
            
            for(Map.Entry<String, Integer> ent : map.entrySet()){
                map.put(ent.getKey(), ent.getValue() + 1);
            }
            
        }
        
        return answer;
    }
}