import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N; // 격자 크기
    static int M; // 이동 횟수
    static int[][] A; // 바구니에 저장되어 있는 물의 양
    static int[][] root; // 이동 정보

    // 이동 방향
    static int[] dx = new int[] {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = new int[] {0, -1, -1, 0, 1, 1, 1, 0, -1};

    // 구름 정보
    static Queue<int[]> cloud;

    // 한 번의 이동에서 사라진 구름 위치
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 바구니 안의 물의 양 입력
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동 정보 입력
        root = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            root[i][0] = Integer.parseInt(st.nextToken());
            root[i][1] = Integer.parseInt(st.nextToken());
        }

        // 초기 구름 정보
        cloud = new LinkedList<>();
        cloud.add(new int[] {N, 1});
        cloud.add(new int[] {N, 2});
        cloud.add(new int[] {N - 1, 1});
        cloud.add(new int[] {N - 1, 2});

        // 이번 이동에서 구름이 사라진 자리라면 true
        visited = new boolean[N + 1][N + 1];

        // M번의 이동
        for (int i = 0; i < M; i++) {
            move(i);
        }

        // 이동이 끝난 후 바구니에 들어있는 물의 양의 합
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += A[i][j];
            }
        }
        System.out.println(result);
    }

    private static void move(int idx) { // idx번의 구름 이동

        // 1. 모든 구름이 root[idx][0] 방향으로 root[idx][1]칸 이동.
        // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
        // 3. 구름이 모두 사라진다.
        moveAndRainAndDisappear(idx);

        // 4. 이번 이동에서 물이 증가한 칸(구름이 이동 후 사라진 칸)에 물복사버그 마법 시전
        copy();

        // 5. 새로운 구름 생성
        makeCloud();
    }

    // 구름 이동 & 비 내림 & 구름 사라짐
    private static void moveAndRainAndDisappear(int idx) {

        int[] now;
        int nx, ny;
        while(!cloud.isEmpty()) {
            // 구름 하나 꺼내기
            now = cloud.poll();

            // 이동 좌표 구하기
            nx = now[0] + dx[root[idx][0]] * root[idx][1];
            if(nx < 1) nx = N + nx % N;
            else if(nx % N == 0) nx = N;
            else if(nx > N) nx = nx % N;

            ny = now[1] + dy[root[idx][0]] * root[idx][1];
            if(ny < 1) ny = N + ny % N;
            else if(ny % N == 0) ny = N;
            else if(ny > N) ny = ny % N;

            // 비내리기
            A[nx][ny] += 1;

            // 구름 사라지며 이 자리에서 구름이 사라졌다고 표시
            visited[nx][ny] = true;
        }
    }

    // 물 복사
    private static void copy() {
        
        // 물 복사될 양만큼 임시로 담고 있는 배열
        int[][] tmpA = new int[N + 1][N + 1];

        int count, nx, ny;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(visited[i][j]) { // 이번 이동에서 구름이 사라진 칸이면 물복사버그 마법
                    count = 0;
                    for (int k = 2; k <= 8; k += 2) { // 대각선 방향으로 거리가 1인 칸 확인
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && A[nx][ny] != 0) { // 확인할 좌표 범위 확인 & 바구니에 물이 있는지 확인
                            count++;
                        }
                    }
                    tmpA[i][j] += count; // 임시 배열에 저장
                }
            }
        }

        // 임시 배열에 저장해두었던 증가값들을 실제 바구니에 증가시켜줌
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] += tmpA[i][j];
            }
        }
    }

    // 새로운 구름 생성
    private static void makeCloud() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 이번 이동에 구름이 사라졌던 칸이라면 다음 이동을 위해 방문 체크 해제
                if(visited[i][j]) visited[i][j] = false;
                // 이번 이동에 구름이 사라졌던 칸이 아니고 물의 양이 2 이상인 칸이라면 구름 생김
                else if(A[i][j] >= 2) {
                    cloud.add(new int[] {i, j});
                    A[i][j] -= 2;
                }
            }
        }
    }
}