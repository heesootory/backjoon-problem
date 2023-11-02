import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < len; j++){
                int k = j;
                int cnt = 0;
                int sum = 0;
                while(cnt < i){
                    if(k == len) k = 0;
                    sum += elements[k];
                    k++;
                    cnt++;
                }
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}