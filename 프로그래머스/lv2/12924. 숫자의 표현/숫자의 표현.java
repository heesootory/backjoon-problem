class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int sum = i;
            int add = i + 1;
            while(true){
                if(sum == n){
                    answer++; break;
                }
                else if(sum > n) break;
                else{
                    sum += add;
                    add++;
                }
            }
        }
        
        return answer;
    }
}