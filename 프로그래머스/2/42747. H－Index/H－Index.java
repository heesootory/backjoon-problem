class Solution {
    public int solution(int[] citations) {
        
        int h = citations.length;
        while(true){
            int cnt = 0;
            int left = 0;
            for(int c : citations){
                if(c >= h) cnt++;
                else left++;
            }
            if(cnt >= h && left <= h) break;
            h--;
        }
        
        return h;
    }
}