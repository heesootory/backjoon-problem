import java.util.*;
import java.io.*;

class Solution {
    static int[][] timetable;

    public int solution(String[][] book_time) {
        int answer = 0;
        timetable = new int[24][60];
        
        for(int i = 0; i < book_time.length; i++){
            
            int start_hour = Integer.parseInt(book_time[i][0].substring(0,2));
            int start_minute = Integer.parseInt(book_time[i][0].substring(3,5));
            int end_hour = Integer.parseInt(book_time[i][1].substring(0,2));
            int end_minute = Integer.parseInt(book_time[i][1].substring(3,5));

            if(end_hour == 23) {
                if(end_minute > 50) end_minute = 59;
                else end_minute += 9;
            }
            else{
                end_minute += 9;
                if(end_minute >= 60){
                    end_hour++; end_minute -= 60;
                }
            }
            
            if(start_hour == end_hour) {
                for(int m = start_minute; m <= end_minute; m++) timetable[start_hour][m]++;
            }
            else{
                for(int m = start_minute; m < 60; m++) timetable[start_hour][m]++;       
                for(int h = start_hour+1; h < end_hour; h++){
                    for(int m = 0; m < timetable[h].length; m++){
                        timetable[h][m]++;
                    }
                }
                for(int m = 0; m <= end_minute; m++) timetable[end_hour][m]++;    
            }

        }
        
        for(int i = 0; i < timetable.length; i++){
            for(int j = 0; j < timetable[i].length; j++){
                answer = Math.max(answer, timetable[i][j]);
            }
        }
        
        
        return answer;
    }
}