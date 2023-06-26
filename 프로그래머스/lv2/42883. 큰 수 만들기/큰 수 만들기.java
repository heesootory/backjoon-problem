import java.util.*;
import java.io.*;

class Solution {
  
    public String solution(String number, int k) {
        int len = number.length();
        
        int ans_len = len - k;
        char[] ans_arr = new char[len - k];
        int start = -1;
        loop:for(int i = 0; i < len - k; i++){
            int max = -1;
            int save = 0;
            for(int j = start + 1; j < len - (ans_len - 1); j++){
                int num = number.charAt(j) - '0';
                if(num > max) {
                    max = num;
                    save = j;
                }
                if(j == len)
                    break loop;
            }
            ans_arr[i] = number.charAt(save);
            start = save;
            ans_len--;
        }
        
        return new String(ans_arr);
    }
}