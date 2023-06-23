import java.util.*;
import java.io.*;

class Solution {
    static int[] percentage = {10, 20, 30, 40};
    static boolean[] visited = new boolean[4];
    static int len;
    static int[] per_arr;       // 순열로 나오는 이모티콘 할인 비율 배열
    static int[][] users_arr;
    static int[] emoticons_price;
    static int join;
    static int total_price;
    
    static void check(){
        int sum = 0;
        int em_cnt = 0;
        for(int i = 0; i < users_arr.length; i++){
            int buy = 0;
            for(int j = 0; j < len; j++){
                if(users_arr[i][0] <= per_arr[j]){
                    buy += (emoticons_price[j] * (100 - per_arr[j]) / 100);
                }
            }
            if(buy >= users_arr[i][1]) em_cnt++;
            else sum += buy;
        }
        if(em_cnt > join) {
            join = em_cnt;
            total_price = sum;
        }
        else if(em_cnt == join) total_price = Math.max(total_price, sum);
    }
    
    static void perm(int idx){
        if(idx == len){
            // System.out.println(Arrays.toString(per_arr));
            check();
            return;
        }
        
        for(int i = 0; i < 4; i++){
            
            per_arr[idx] = percentage[i];
            perm(idx + 1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        len = emoticons.length;
        per_arr = new int[len];         // 이모티콘 마다 할인률 경우들
        int[] answer = new int[2];
        users_arr = users;
        emoticons_price = emoticons;
        
        perm(0);
        answer[0] = join;
        answer[1] = total_price;
        
        return answer;
    }
}