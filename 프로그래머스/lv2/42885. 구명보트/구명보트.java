import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int[] people, int limit) {
        int len = people.length;
        visited = new boolean[len];
        
        Arrays.sort(people);
        int cnt = 0;
        int min = 0;
        
        for(int max = len-1; max >= min; max--){
            if(people[min] + people[max] <= limit) min++;
            cnt++;
        }
        
        return cnt;
    }
}