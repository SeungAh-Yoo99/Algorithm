import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static ArrayList<int[]> virus;
    static int[][][] spread_time;
    static int result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new ArrayList<>(); // 바이러스 위치 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) { // 바이러스 위치 저장
                    virus.add(new int[] {i, j});
                }
            }
        }

        // 각 바이러스마다 모든 공간에 퍼트리는데 걸리는 시간 구하기
        spread_time = new int[virus.size()][N][N];
        for (int i = 0; i < virus.size(); i++) {
            spread(i);
        }

        // 바이러스들 중 M개의 바이러스만 활성하기
        result = N * N;
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], N * N);
        }
        combi(cost, 0, 0);

        if(result == N * N) System.out.println(-1);
        else System.out.println(result);
    }

    private static void spread(int n) { // n번째 바이러스를 모든 공간에 퍼트리는데 걸리는 시간

        // n번째 바이러스 위치
        int x = virus.get(n)[0];
        int y = virus.get(n)[1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(spread_time[n][i], N * N);
        }
        spread_time[n][x][y] = 0;


        // bfs 사방탐색
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, 0});

        int[] now;
        int nx, ny;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) { // 사방탐색
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
                    if(map[nx][ny] != 1 && spread_time[n][nx][ny] > now[2] + 1) { // 벽이 아니고 방문 전이라면 이동
                        spread_time[n][nx][ny] = now[2] + 1;
                        q.add(new int[] {nx, ny, now[2] + 1});
                    }
                }
            }
        }
    }

    private static void combi(int[][] cost, int start, int n) { // 백트래킹으로 M개의 바이러스를 골라 활성화

        if(n == M) { // M개의 바이러스를 활성화 시켰다면
            int maxCost = 0; // 현재 경우에서 최대 시간 구하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 0) maxCost = Math.max(maxCost, cost[i][j]);
                }
            }

            result = Math.min(result, maxCost); // 최대 시간 중 가장 빠른 시간을 답으로 저장
            return;
        }

        int[][] tmp;
        for (int i = start; i < virus.size() - (M - n - 1); i++) { // i번째 바이러스 활성화
            // 이전 바이러스 활성 정보 딥카피
            tmp = new int[N][];
            for (int j = 0; j < N; j++) {
                tmp[j] = cost[j].clone();
            }

            // 이전 바이러스 활성 정보에서 이번에 고른 바이러스 활성 정보를 합쳐줌
            // 이번 바이러스를 활성함으로 바이러스 확산 시간이 더 빨라진 장소들 갱신
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmp[j][k] = Math.min(tmp[j][k], spread_time[i][j][k]);
                }
            }

            // 다음 바이러스 고르거
            combi(tmp, i + 1, n + 1);
        }
    }
}