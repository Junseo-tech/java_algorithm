import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {



        while(true) {
            String line = br.readLine();
            if(line == null) break;


            StringTokenizer st = new StringTokenizer(line);

            String s = st.nextToken();
            String t = st.nextToken();

            boolean answer = isSubString(s, t);
            if (answer) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");

        }

        System.out.println(sb);

    }


    private static boolean isSubString(String s, String t) {
        int count = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = start; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    count++;
                    start = j + 1;
                    break;
                }
            }
        }

        if(count == s.length()) return true;
        else return false;

    }
}
