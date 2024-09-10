import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<Integer> card = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder result = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int c;
        for (int i = 0; i < M; i++) {
            c = Integer.parseInt(st.nextToken());

            if(card.contains(c)) result.append("1 ");
            else result.append("0 ");
        }

        System.out.println(result);
    }
}