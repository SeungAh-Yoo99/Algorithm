import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 발전소의 수, W := 남아있는 전선의 수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // M := 제한 길이
        double M = Double.parseDouble(br.readLine());

        // 발전소 좌표
        int[][] point = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        // 연결 전선 정보
        boolean[][] connected = new boolean[N + 1][N + 1];
        int a, b;
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            connected[a][b] = true;
            connected[b][a] = true;
        }

        // 1번 발전소에서 다른 발전소까지 연결하는데 필요한 추가 전선 길이의 최솟값
        double[] line = new double[N + 1];
        Arrays.fill(line, Double.MAX_VALUE);
        line[1] = 0;

        // 다익스트라로 최단길이 구하기
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] < o2[0] ? -1 : 0);
        pq.add(new double[] {0, 1});

        double[] now;
        double len;
        while(!pq.isEmpty()) {
            now = pq.poll(); // 현재 확인할 지점

            // 이미 더 짧은 루트를 찾았거나, 현재 지점이 N이라면 넘어감
            if(now[0] > line[(int)now[1]] || (int)now[1] == N) continue;

            for (int i = 1; i <= N; i++) { // 현재 지점에서 다른 지점으로 더 짧은 루트로 갈 수 있는 경우를 찾음
                if(connected[(int)now[1]][i]) len = now[0]; // 이미 연결된 발전소면 추가 전선 필요하지 않음
                else len = now[0] + Math.sqrt(Math.pow(point[i][0] - point[(int)now[1]][0], 2) + Math.pow(point[i][1] - point[(int)now[1]][1], 2)); // 연결되어 있지 않다면 추가 전선 연결
                if(line[i] > len) { // 찾았다면
                    line[i] = len; // 짧은 루트 갱신
                    pq.add(new double[] {len, i}); // 다음으로 체크
                }
            }
        }



        // 출력
        System.out.println((int)(line[N] * 1000));
    }
}