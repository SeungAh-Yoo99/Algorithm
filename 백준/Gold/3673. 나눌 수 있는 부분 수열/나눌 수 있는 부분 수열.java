import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        int d, n, sum, tmp, result;
        Map<Integer, Integer> map;
        for (int tc = 0; tc < c; tc++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new HashMap<>();

            sum = 0;
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(st.nextToken());
                sum %= d;

                tmp = map.getOrDefault(sum, 0);
                result += tmp;
                if(sum % d == 0) result++;
                map.put(sum, tmp + 1);
            }

            answer.append(result + "\n");
        }

        System.out.println(answer);
    }
}