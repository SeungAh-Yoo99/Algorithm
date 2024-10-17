import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 카드 순서 배열
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 바로 앞에 있는 같은 아이디의 카드 위치 구하기
        int[] preIndex = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        Integer pre;
        for (int i = 0; i < N; i++) {

            pre = map.get(arr[i]);

            // 이전에 같은 아이디의 게임이 있는 경우
            if(pre != null) preIndex[i] = pre;
            // 없는 경우엔 -1로 초기화
            else preIndex[i] = -1;

            map.put(arr[i], i);
        }

        // 이분 탐색
        int s = 0, e = N, m;
        int count, start;
        int result = 1;
        while(s <= e) {
            m = (s + e) / 2;

            // 하나의 카드 팩에 m개의 게임을 넣고 M개의 카드 팩을 구성할 수 있는지 확인
            count = 0;

            start = 0;
            for (int i = 1; i < N; i++) {
                // 현재 구성 중인 카드 팩에 같은 아이디의 게임이 있는지 확인
                if(preIndex[i] >= start) { // 같은 아이디의 게임이 있으면
                    start = preIndex[i] + 1; // 같은 아이디의 게임 빼줌
                }

                // m개의 게임을 구성할 수 있는 카드 팩 하나 발견
                if(i - start + 1 == m) {
                    count++;
                    start = i + 1;
                }
            }

            // m개의 게임을 넣고 M개의 카드 팩을 구성할 수 있는 경우
            if(count >= M) {
                result = m;
                s = m + 1;
            } else e = m - 1;
        }

        System.out.println(result);
    }
}