import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 내림차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        // 표의 맨 밑 줄 N개 pq에 추가
        for (int i = 0; i < N; i++) {
            pq.add(new int[] {table[N - 1][i], N - 1, i});
        }

        int count = 0;
        int[] now = new int[3];
        while(count++ < N) {
            now = pq.poll();

            // now[2]번째 행의 now[1] - 1번째 원소 추가
            if(now[1] > 0) pq.add(new int[] {table[now[1] - 1][now[2]], now[1] - 1, now[2]});
        }

        // N번째 큰 수 출력
        System.out.println(now[0]);
    }
}
