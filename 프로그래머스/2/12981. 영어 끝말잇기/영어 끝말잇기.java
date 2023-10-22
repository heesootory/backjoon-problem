import java.util.*;

class Solution {
    static HashMap<String, String> map;
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        map = new HashMap<>();
        
        // 동일한 단어가 나왔는지 확인.
        int a = 0, b = 0;
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                a = i % n + 1;
                b = i / n + 1;
                break;
            }
            map.put(words[i], "");
        }
        
        // 끝말잇기 규칙에 맞는지 확인.
        int c = 0, d = 0;
        for(int i = 1; i < words.length; i++){
            int len = words[i - 1].length();
            if(words[i].charAt(0) != words[i - 1].charAt(len - 1)) {
                c = i % n + 1;
                d = i / n + 1;
                break;
            }
        }
        
        System.out.println(a + " " + c);
        
        if(a != 0 && c != 0){
            System.out.println("act");
            if(a < c){
                answer[0] = a;
                answer[1] = b;
            }
            else{
                answer[0] = c;
                answer[1] = d;
            }
        }
        else if(a != 0){
            answer[0] = a; answer[1] = b;
        }
        else if(c != 0) {
            answer[0] = c; answer[1] = d;
        }

        return answer;
    }
}