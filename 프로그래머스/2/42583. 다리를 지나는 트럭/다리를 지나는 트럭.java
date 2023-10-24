import java.util.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int next = 0;
        int sum = 0;
        int total_truck = truck_weights.length;
        
        while(true){
        
            int len = queue.size();
            
            // 다리에서 내려오는 경우.
            if(len == bridge_length){
                if(sum == 0) break;
                
                int out = queue.poll();
                sum -= out;
                len--;
            }
            
            if(next < total_truck){
                if(len < bridge_length){
                    if(sum + truck_weights[next] <= weight){    // 다리에 트럭이 올라올 수 있는 경우
                        queue.add(truck_weights[next]);
                        sum += truck_weights[next];
                        next++;
                    }
                    else queue.add(0);
                }
            }
            else queue.add(0);
            
            time++;
            
            // System.out.println("시간 : " + time +  " / " + queue.toString());
        }
        
        return time;
    }
}