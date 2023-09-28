
import java.util.*;

class Solution {
    static int GCD(int max, int min){
        if(max % min == 0) return min;
        
        return GCD(min, max % min);
    }
    
    static int lcm(int a, int b){
        return a * b / GCD(a, b);
    }
    
    public int solution(int[] arr) {
//         int answer = 0;
        
//         Arrays.sort(arr);
//         int gcd = arr[0];
        
//         for(int i : arr){
//             gcd = GCD(i, gcd);
//         }
        
//         // 최소공배수 구하기
//         answer = gcd;
//         for(int i : arr){
//             answer *= (i / gcd);
//             System.out.println(answer);
//         }
        
        // return answer;
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
                answer = lcm(answer, arr[i]);
        }
        return answer;
    }
}