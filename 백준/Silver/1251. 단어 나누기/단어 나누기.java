import java.io.*;
import java.util.*;



public class Main{
    static String[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        arr = new String[3];

        int len = str.length();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                arr[0] = str.substring(0, i);
                arr[1] = str.substring(i, j);
                arr[2] = str.substring(j, len);

                for (int a = 0; a < 3; a++) {
                    String s = arr[a];
                    String newString = "";
                    for (int k = s.length() - 1; k >= 0; k--) {
                        newString += s.charAt(k);
                    }
                    arr[a] = newString;
                }

                String sumString = "";
                for(String sttt : arr) sumString += sttt;
                list.add(sumString);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }
}