import java.util.*;

class Solution
{
    static int log2(int number){
        return (int)(Math.log10(number) / Math.log10(2));
    }
    
    static int divide(int start, int end, int a, int b){
        int check = 1;
        int range = (end - start) / 2;
        
        if(start < a && a <= start + range) check *= 1;
        if(start < b && b <= start + range) check *= 1;
        
        if(start + range < a && a <= end) check *= 2;
        if(start + range < b && b <= end) check *= 2;
        
        if(check == 1) return divide(start, start + range, a, b);
        else if(check == 4) return divide(start + range, end, a, b);
        else return log2(end - start);
    }
    
    public int solution(int n, int a, int b)
    {
        
        return divide(0, n, a, b);
    }
}