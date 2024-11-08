import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N, M;
        Set<Integer> set;
        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(br.readLine());

            set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if(set.contains(Integer.parseInt(st.nextToken()))) {
                    result.append("1\n");
                }
                else result.append("0\n");
            }
        }

        System.out.print(result);
    }
}