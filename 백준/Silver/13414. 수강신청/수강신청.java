import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int limit = Integer.parseInt(st.nextToken());
        int student = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> list = new LinkedHashSet<>();

        for(int i = 0; i<student; i++)
        {
            String s = br.readLine();
            if(list.contains(s))
            {
                list.remove(s);
            }
            list.add(s);
        }

        for(Object s : list.toArray())
        {
            if(limit > 0)
            {
                System.out.println(s);
                limit--;
            }

        }
    }
}