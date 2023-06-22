import java.util.*;
import java.io.*;

class Solution {
    static HashMap<Long, Long> map = new HashMap<>();
    
    static long findEmptyRoom(long room){
        // 방이 비어있을 경우.
        if(!map.containsKey(room)){
            map.put(room, room+1);      // 다음 가능한 방의 번호를 저장해줌.
            return room;
        }
        
        // 방이 차있을 경우.
        long next_room = map.get(room);
        long empty_room = findEmptyRoom(next_room);
        map.put(room, empty_room + 1);
        return empty_room;
    }
    
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        
        for(int i = 0; i < len; i++){
            answer[i] = findEmptyRoom(room_number[i]);
        }
        
        return answer;
    }
}