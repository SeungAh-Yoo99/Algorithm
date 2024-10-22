import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String command = st.nextToken();

        // 인원수
        int limit = command.equals("Y") ? 1 : command.equals("F") ? 2 : 3;

        int result = 0;
        int count = 0;

        // 이미 게임을 한 사람 목록
        Set<String> set = new HashSet<>();

        String name;
        for (int i = 0; i < N; i++) {
            name = br.readLine();

            if(!set.contains(name)) {
                set.add(name);
                count++;

                if(count == limit) {
                    result++;
                    count = 0;
                }
            }
        }

        System.out.println(result);
    }
}