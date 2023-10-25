import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] arr = new String[len];
        
        // 모든 숫자 배열 -> 문자 배열
        for(int i = 0; i < len; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열 사전순 비교로 -> 내림차순으로 정렬
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2){
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        // 그대로 다 더해버리기.
        for(String s : arr) answer += s;
        
        return (answer.charAt(0) == '0') ? "0" : answer;
    }
}