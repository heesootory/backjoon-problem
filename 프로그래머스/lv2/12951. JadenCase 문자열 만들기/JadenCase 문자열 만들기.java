class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            String now = arr[i];
            
            if(now.length() == 0) answer += " ";
            else{
                String str = now.substring(0, 1).toUpperCase() + now.substring(1).toLowerCase();
                answer += str;
                if(i != arr.length - 1) answer += " ";
            }
        }
        
        if(s.substring(s.length() - 1, s.length()).equals(" ")) answer += " ";
        
        
        return answer;
    }
}