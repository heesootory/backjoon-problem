import java.util.*;
import java.io.*;

class Time implements Comparable<Time>{
    int start, end;
    public Time (int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Time t){
        if(this.end == t.end) return this.start - t.start;
        else return this.end - t.end;
    }
}

public class Main{
    static int N;
    static ArrayList<Time> timetable;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        timetable = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            timetable.add(new Time(s, e));
        }

        Collections.sort(timetable);

        int finalTime = 0;
        int cnt = 0;
        for(Time t : timetable){
//            System.out.println(t.start + " " + t.end);
            if(t.start >= finalTime) {
                cnt++;
                finalTime = t.end;
            }
        }

        System.out.println(cnt);


    }
}