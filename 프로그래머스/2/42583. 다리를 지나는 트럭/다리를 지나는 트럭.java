import java.util.*;

class Truck{
    int weight, move;
    
    public Truck(int weight){
        this.weight = weight;
        this.move = 1;
    }
    
    public void moving(){
        this.move++;
    }
}
class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();
        
        // 모든 트럭을 대기큐에 삽입.
        for(int i : truck_weights) waitQ.add(new Truck(i));
        
        int time = 0;
        int total_weight = 0;
        
        while(!moveQ.isEmpty() || !waitQ.isEmpty()){
            
            time++;     // 0초에는 아무 행동도 안하고 넘어갔음. 1초부터 진입시작. 
            
            // 첫 회 - 다리에 아무것도 없을 때
            if(moveQ.isEmpty()){
                Truck enter = waitQ.poll();
                total_weight += enter.weight;
                moveQ.add(enter);
                continue;
            }
            
            // 모든 다리에 있는 트럭들 이동.
            for(Truck t : moveQ) t.move++;
            
            // 다리를 다 지난 트럭들 빼기. - 이동되어 다리길이를 초과한 트럭들 발생.
            if(moveQ.peek().move > bridge_length){
                Truck out = moveQ.poll();
                total_weight -= out.weight;
            }
            
            // 다음 트럭이 올라갈 수 있다면 진입.
            if(!waitQ.isEmpty() && waitQ.peek().weight + total_weight <= weight){
                Truck enter = waitQ.poll();
                total_weight += enter.weight;
                moveQ.add(enter);
            }
        }
        
        return time;
    }
}