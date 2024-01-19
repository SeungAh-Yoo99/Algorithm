import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution  {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // T := 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        int N, K, result; int[] arr, now;
        for (int tc = 1; tc <= T; tc++) {
            // N := 정수 개수
            N = Integer.parseInt(br.readLine());

            // 정수 입력
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // K := 만들고자 하는 수
            K = Integer.parseInt(br.readLine());

            // K에서 0을 만들어주는 경우 확인 (1을 뺀 횟수로 올림차순 정렬)
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            pq.add(new int[] {K, 0});

            while(!pq.isEmpty()) {
                now = pq.poll();

                if(now[0] == 0) { // 0 만든 경우 확인
                    System.out.println("#" + tc + " " + now[1]);
                    break;
                }

                // 1 빼기로 0 만든 경우 pq에 넣기
                pq.add(new int[] {0, now[1] + now[0]});

                // 1 빼기로 arr[i]로 나누어 떨어지게 만든 후, arr[i]로 나눈 경우
                for (int i = 0; i < N; i++) {
                    pq.add(new int[] {now[0] / arr[i], now[1] + now[0] % arr[i]});
                }
            }
        }
    }

}