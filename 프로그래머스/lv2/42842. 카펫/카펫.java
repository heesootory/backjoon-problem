import java.io.*;
import java.util.*;

class Solution {
    static int total;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        total = brown + yellow;
        int x = 1;
        int y = 0;
        for(; x < total; x++){
            if(total % x == 0){
                y = total / x;
                if(2 * x + 2 * y - 4 == brown) break;
            }
        }
        
        answer[0] = Math.max(x, y);
        answer[1] = Math.min(x, y);
    
        return answer;
    }
}