import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
        public int solution(int[] scoville, int K) {
        int answer = 0;
        
        for(int i : scoville) pq.add(i);
            
        while(pq.peek() < K){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            int small = first + second * 2;
            pq.add(small);
        }
        
        return answer;
    }
}