import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= len; i++){          // 부분 수열의 개수.
            for(int j = 0; j < len; j++){       // 수열 카운트를 시작할 인덱스
                int sum = 0;
                for(int cnt = 0, idx = j; cnt < i; cnt++, idx++){
                    sum += elements[idx % len];
                }
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}