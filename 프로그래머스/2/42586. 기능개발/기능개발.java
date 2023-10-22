import java.util.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    
    public Integer[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) queue.add(progresses[i]);
        int outCnt = 0;
        int before = 0;
        
        while(!queue.isEmpty()){
            boolean check = false;
            int len = queue.size();
            
            for(int i = 0, j = outCnt; i < len; i++, j++){
                int task = queue.poll();
                task += speeds[j];
                queue.add(task);
            }
            
            for(int i = 0; i < len; i++){
                if(queue.peek() < 100) break;
                else {
                    queue.poll();
                    outCnt++;
                    check = true;
                }
            }
            
            if(check) {
                list.add(outCnt - before);
                before = outCnt;
            }
        }   
        
        int total = list.size();
        Integer[] arr = list.toArray(new Integer[total]);
        return arr;
    }
}