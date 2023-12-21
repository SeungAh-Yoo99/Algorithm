import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        final int MAX;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 건물의 개수, M := 도로의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        MAX = N * M + 1;

        // 도로 정보 저장
        int[][] edges = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(edges[i], MAX);
        }

        // 도로 정보 입력
        int A, B;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            edges[A][B] = 1;
            edges[B][A] = 1;
        }

        // N이 100 이하이므로 플로이드-워셜로 각 도시에서 다른 도시로의 최단 거리 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    edges[j][k] = Math.min(edges[j][k], edges[j][i] + edges[i][k]);
                }
            }
        }

        // 두 가게를 조합하여 최단 거리 구하기
        int building1 = 0, building2 = 0, sumOfDis = MAX * N, sum;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) continue; // 같은 건물일 경우 넘어가기

                sum = 0;
                for (int k = 1; k <= N; k++) {
                    if(k == i || k == j) continue; // 치킨집일 경우 넘어가기
                    sum += Math.min(edges[k][i], edges[k][j]);
                }
                if(sum < sumOfDis) {
                    building1 = i;
                    building2 = j;
                    sumOfDis = sum;
                }
            }
        }

        // 출력
        // 왕복 거리이므로 최단 거리에 x2를 해줌
        System.out.println(building1 + " " + building2 + " " + (sumOfDis * 2));
    }
}