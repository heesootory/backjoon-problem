import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
            
        Arrays.sort(A);
        Arrays.sort(B);
        
        int j = 0;
        for(int i = 0; i < A.length;){
            if(j >= B.length) break;
            if(B[j] > A[i]) {
                answer++; i++; j++;
            }
            else j++;
        }
            
        return answer;
    }
}