import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] move;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 4분 탐색을 위한 좌표
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 대나무 숲의 크기 n 입력
        n = Integer.parseInt(br.readLine());

        // 대나무 숲의 정보 입력
        map = new int[n][n];

        // 대나무 수에 따라 내림차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new int[] {map[i][j], i, j});
            }
        }

        // 대나무 수에 따라 내림차순으로 해당 칸에서 얼마나 이동할 수 있는지 체크
        move = new int[n][n]; // 각 칸에 대한 이동 가능 경우의 수 저장
        visited = new boolean[n][n]; // 이동 가능 경우의 수를 체크했을 경우 true

        int result = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(visited[now[1]][now[2]]) continue;
            else {
                int tmp = maxMove(now[1], now[2]);
                result = result < tmp ? tmp : result;
            }
        }

        // 출력(시작 칸까지 포함하여 출력)
        System.out.println(result + 1);
    }

    private static int maxMove(int x, int y) {

        int ret = 0; // 사방 중 가장 많이 움직일 수 있는 경우의 수
        int nx, ny;
        for (int i = 0; i < 4; i++) { // 사방탐색
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n) { // 범위 체크
                // 갈 수 없는 곳이라면 넘어감
                if(map[nx][ny] <= map[x][y]) continue;
                // 대나무가 더 많은 곳이라면 이미 경우의 수를 구한 자리. 바로 비교 결과 저장
                else ret = ret < move[nx][ny] + 1 ? move[nx][ny] + 1 : ret;
            }
        }

        visited[x][y] = true; // 현재 좌표 방문체크
        move[x][y] = ret; // 결과 저장

        return ret;
    }
}