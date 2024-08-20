import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // key := 학번
        // value := key 학번이 몇 번 눌렀는지
        Map<String, Integer> map = new HashMap<>();

        // 대기열 순서
        Queue<String> q = new LinkedList<>();

        String id;
        for(int i = 0; i < L; i++) {
            id = br.readLine();
            map.put(id, map.getOrDefault(id, 0) + 1);
            q.add(id);
        }

        StringBuilder result = new StringBuilder();
        int count = 0; // 확정된 학생 수
        while(!q.isEmpty()) {
            id = q.poll();

            if(map.get(id) == 1) {
                result.append(id + "\n");
                if(++count == K) break;
            }
            else {
                map.put(id, map.get(id) - 1);
            }
        }

        System.out.print(result);
    }
}