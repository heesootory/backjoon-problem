class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 숫자를 문자 배열로 변환.
        String str = String.valueOf(storey);
        char[] chars = str.toCharArray();
        int[] nums = new int[chars.length];
        for(int i = 0; i < chars.length; i++) nums[i] = chars[i] - '0';
        
        // 로직 실행
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == 10){
                if(i == 0){     // 가장 첫 번째 수라면
                    answer++;
                    break;
                }
                else nums[i - 1]++;
            }
            else if(nums[i] >= 6){
                answer += (10 - nums[i]);
                if(i == 0) {
                    answer++;
                    break;
                }
                nums[i - 1]++;
            }
            else if(nums[i] <= 4){
                answer += nums[i];
            }
            else if(nums[i] == 5){
                if(i == 0){         
                    answer += nums[i];
                    break;
                }else{
                    if(nums[i - 1] < 5) answer += nums[i];
                    else {
                        answer += nums[i];
                        nums[i - 1]++;
                    }
                }
            }
        }
        
        return answer;
    }
}