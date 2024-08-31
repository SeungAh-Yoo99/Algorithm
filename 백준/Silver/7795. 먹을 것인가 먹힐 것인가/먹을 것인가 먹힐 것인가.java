import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N, M;
        int[] A, B;
        int[] canEat;
        int idx;
        int count;
        for (int tc = 0; tc < T; tc++) {

            count = 0;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(A);
            Arrays.sort(B);

            // A가 먹을 수 있는 B의 개수를 구하기
            canEat = new int[N];
            idx = 0;
            for (int i = 0; i < N; i++) {
                while(idx < M && A[i] > B[idx]) {
                    canEat[i]++;
                    idx++;
                }
                // i - 1번째 물고기가 먹을 수 있는 먹이는 i번째 물고기도 먹을 수 있음
                if(i != 0) canEat[i] += canEat[i - 1];
                count += canEat[i];
            }

            // 답 저장
            result.append(count).append("\n");
        }

        // 출력
        System.out.print(result);
    }
}