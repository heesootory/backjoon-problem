import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= len; i++){          // 부분 수열의 개수.
            for(int j = 0; j < len; j++){       // 수열 카운트를 시작할 인덱스
                int idx = j;            // 실제 카운트하는 인덱스
                int cnt = 0;
                int sum = 0;
                while(cnt < i){
                    if(idx == len) idx = 0;     // 순환 (맨 끝 -> 처음으로)
                    sum += elements[idx];
                    idx++;
                    cnt++;
                }
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}