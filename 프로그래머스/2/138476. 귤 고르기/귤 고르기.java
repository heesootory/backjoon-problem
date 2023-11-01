import java.util.*;

class Pair implements Comparable<Pair>{
    int num;
    int cnt;
    Pair(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(Pair o){
        return o.cnt - this.cnt;
    }
}

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        ArrayList<Pair> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : tangerine) map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(int i : map.keySet()){
            list.add(new Pair(i, map.get(i)));
        }
        
        Collections.sort(list);
        
        int sum = 0;
        for(Pair p : list){
            if(sum >= k) break;
            sum += p.cnt;
            answer++;
        }
                
        return answer;
    }
}