class Solution { 
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int binary_change_cnt = 0;
        int zero_remove_cnt = 0;
        
        while( !s.equals("1")){
            
            int one_cnt = 0;
            
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '0') zero_remove_cnt++;
                else one_cnt++;
            }
            
            s = Integer.toBinaryString(one_cnt);
            binary_change_cnt++;
        }
        
        answer[0] = binary_change_cnt;
        answer[1] = zero_remove_cnt;
        
        return answer;
    }
}