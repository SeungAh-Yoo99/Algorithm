import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String s;

        // 포켓몬 번호로 접근하여 포켓몬 이름을 얻기 위한 리스트
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        // 포켓몬 이름으로 포켓몬 번호를 얻기 위한 맵
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            s = br.readLine();
            list.add(s);
            map.put(s, i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            s = br.readLine();

            // 숫자인 경우
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                result.append(list.get(Integer.parseInt(s))).append("\n");
            }
            // 문자열인 경우
            else {
                result.append(map.get(s)).append("\n");
            }
        }

        System.out.print(result);
    }
}