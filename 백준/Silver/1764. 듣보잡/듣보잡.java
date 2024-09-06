import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        String s;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            // 보도 못한 사람이 듣도 못한 사람일 경우
            if(set.contains(s)) list.add(s);
        }

        // 사전 순 정렬
        Collections.sort(list);

        StringBuilder result = new StringBuilder();
        result.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i)).append("\n");
        }

        System.out.println(result);
    }
}