import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        String line;

        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            String[] lines = line.split(" ");

            if(lines.length < 2) break;

            String s = lines[0];
            String t = lines[1];

            boolean answer = isSubString(s, t);
            if(answer) sb.append("Yes").append("\n");
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
