import java.util.*;
import java.io.*;

public class Solution {
    static Stack<Integer> stack;
    public int[] solution(int []arr) {
        stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()) stack.push(arr[i]);
            
            if(stack.peek() != arr[i]) stack.push(arr[i]);
        }
        
        int len = stack.size();
        
        int[] answer = new int[len];
        for(int i = len - 1; i >= 0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}