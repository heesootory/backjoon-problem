import java.util.*;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] countArr = new int[10];
        Queue<Pair> queue = new LinkedList<>();
        int cnt = 0;
        for(int i : priorities){
            countArr[i]++;
            queue.add(new Pair(cnt, i));
            cnt++;
        }
        
        loop: for(int i = 9; i >= 0; i--){
            while(countArr[i] > 0){
                Pair curr = queue.poll();
                if(curr.y == i) {
                    answer++;
                    countArr[i]--;
                    if(curr.x == location) break loop;
                }else queue.add(curr);
            }
        }
        
        
        return answer;
    }
}