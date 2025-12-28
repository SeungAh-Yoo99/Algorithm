import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        int result = 0;

        String s;
        for (int i = 0; i < M; i++) {
            s = br.readLine();

            if(S.contains(s)) result++;
        }

        System.out.println(result);
    }
}
