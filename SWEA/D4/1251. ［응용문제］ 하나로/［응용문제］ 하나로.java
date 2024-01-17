import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 전체 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        int N; int[][] map; double E, result; double[] edge;
        for (int tc = 1; tc <= T; tc++) {
            // N := 섬의 개수
            N = Integer.parseInt(br.readLine());

            // 섬의 좌표
            map = new int[N][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            // E := 세율
            E = Double.parseDouble(br.readLine());

            // 크루스칼 알고리즘 사용을 위해 모든 정점 사이의 거리를 구해준다
            PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] < o2[2] ? -1 : 1);
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    pq.add(new double[] {i, j, Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2)});
                }
            }

            // 유니온 파인드를 위한 부모 배열
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            // 크루스칼 알고리즘
            result = 0;
            while(!pq.isEmpty()) {
                edge = pq.poll();

                if(union((int)edge[0], (int)edge[1])) result += edge[2];
            }

            // 환경 부담 세율 적용
            result *= E;

            // 답 저장
            answer.append("#" + tc + " " + Math.round(result) + "\n");
        }

        // 출력
        System.out.println(answer);
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) { // a와 b를 새로 연결해주어야 한다면 ture, 이미 연결되어 있다면 false 리턴

        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}