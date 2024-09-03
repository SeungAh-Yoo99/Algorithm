import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[][] visited;

    // 사방탐색(상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void getArea(int x, int y, int h) {

        visited[x][y] = true; // 방문체크

        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        int[] now;
        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 범위 체크 & 잠기는 높이보다 높은지 체크 & 방문체크
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] > h && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행과 열의 개수 N 입력
        N = Integer.parseInt(br.readLine());

        // 높이 정보 입력
        graph = new int[N][N];
        int minH = 100; // 가장 낮은 높이
        int maxH = 1; // 가장 높은 높이
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, graph[i][j]);
                maxH = Math.max(maxH, graph[i][j]);
            }
        }

        int result = 1; // 답

        for (int i = minH; i < maxH; i++) { // 최소 높이부터 최대 높이 - 1까지 물에 잠기는 높이로 설정
            visited = new boolean[N][N]; // 방문체크
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 물에 잠기지 않은 곳이고 방문하지 않았다면
                    if(graph[j][k] > i && !visited[j][k]) {
                        getArea(j, k, i);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }

        // 출력
        System.out.println(result);
    }

}