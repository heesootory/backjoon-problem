import java.util.*;
import java.io.*;


public class Main{
    static HashMap<String, Integer> map = new HashMap<>();
    static int cnt;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while(true){
            line = br.readLine();
            if(line == null || line.length() == 0) break;
            cnt++;
            if(map.containsKey(line)) map.put(line, map.get(line) + 1);
            else {
                map.put(line, 1);
                list.add(line);
            }
        }

        Collections.sort(list);
        for(String s : list) {
            Double ans = ((double)map.get(s)*100/cnt) ;
            System.out.println(s + " " + String.format("%.4f", ans));
        }



    }
}