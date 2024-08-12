package august.twelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class i_want_to_get_special_award {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> seats = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            List<Integer> seat = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                seat.add(value);
            }
            seats.add(seat);
        }
    }

    private static void splitSeats(){

    }
}
