class Solution {
    
    
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for(int t = 0; t < len; t++){
            String str = Long.toBinaryString(numbers[t]);   
            str = "0" + str;
            
            char[] arr = str.toCharArray();
            
            int idx = -1;
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i] == '0'){
                    arr[i] = '1';
                    idx = i; break;
                }
            }
            
            for(int i = idx+1; i < arr.length; i++){
                if(arr[i] == '1'){
                    arr[i] = '0'; break;
                }
            }
            
            long j = 1;
            long sum = 0;
            for(int i = arr.length - 1; i >= 0; i--){
                sum += (arr[i] - '0') * j;
                j *= 2;
            }
            
            answer[t] = sum;
        }
        
        return answer;
    }
}