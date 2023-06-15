import java.io.*;
import java.util.*;

class Solution {
    static int[] dp1;
    static int[] dp2;
    
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int max1 = 0;
        int max2 = 0;
        
        dp1 = new int[money.length];
        dp2 = new int[money.length];
        
        dp1[0] = money[0];
        dp1[1] = money[1];
        dp1[2] = dp1[0]+money[2]; 
        
        dp2[1] = money[1];
        dp2[2] = money[2];
        
        for(int i = 3; i < len; i++){
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + money[i];
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + money[i];
        }
        
        answer = Math.max(Math.max(dp1[len-2], dp1[len-3]), Math.max(dp2[len-2], dp2[len-1]));
        return answer;
    }
}