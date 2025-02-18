import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 줄의 시작과 끝점을 담기 위한 Map
        Map<Integer, Integer> map = new HashMap<>();

        int s, e, tmp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            // 시작점이 더 앞에 오도록 설정
            if(s > e) {
                tmp = s;
                s = e;
                e = tmp;
            }
            // 시작점, 끝점 저장
            map.put(s, map.getOrDefault(s, 0) + 1); // 시작점엔 +1
            map.put(e, map.getOrDefault(e, 0) - 1); // 끝점엔 -1
        }

        // map의 key들을 정렬한 리스트
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        // 줄이 그어진 곳 계산
        int answer = 0, count = 0;
        s = -1;
        for(int key : list) {
            count += map.get(key);

            // 줄의 시작을 찾았다면
            if(count > 0 && s == -1) {
                s = key;
            }
            // 줄의 끝을 찾았다면
            else if(count == 0 && s != -1) {
                answer += key - s;
                s = -1;
            }
        }

        System.out.println(answer);
    }
}