import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int start, end;
    public Pair(int start, int end){
        this.start = start + 30000;
        this.end = end + 30000;
    }
    
    public int compareTo(Pair p){
        if(this.end == p.end) return this.start - p.start;
        else return this.end - p.end;
    }
}

class Solution {
    static ArrayList<Pair> list = new ArrayList<>();
    public int solution(int[][] routes) {
        
        for(int i = 0; i < routes.length; i++){
            list.add(new Pair(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(list);
        int cnt = 0;
        int time = 0;
        
        for(int i =0 ; i < list.size(); i++){
            if(list.get(i).start > time){
                cnt++;
                time = list.get(i).end;
            }
        }
        
        return cnt;
    }
}