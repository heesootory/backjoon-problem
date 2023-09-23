class Solution {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split(" ");
        
        for(int i = 0; i < strArr.length; i++){
            String str = strArr[i];
            int num = 0;
            int t = 1;
            int len = str.length() - 1;
            while(len >= 0){
                int c = str.charAt(len) - '0';
                if(0 <= c && c <= 9){
                    num += c * t;
                    t *= 10;   
                }
                else num *= -1;
                len--;
            }
            
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        answer += Integer.toString(min);
        answer += " ";
        answer += Integer.toString(max);
        return answer;
    }
}