class Solution { 
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while( !s.equals("1")){
            int len = s.length();
            s = s.replaceAll("0", "");
            int tmp = s.length();
            answer[1] += (len - tmp);
            s = Integer.toBinaryString(tmp);
            answer[0]++;
        }
        
        return answer;
    }
}