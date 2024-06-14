import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] can_move;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 위치에서 제일 오른쪽 아래 지점까지 갈 수 있는지 없는지
        // -1: 이동할 수 없음, 0: 아직 확인 전, 1~: 현재 자리에서 가능한 경로 개수
        can_move = new int[M][N];
        can_move[M - 1][N - 1] = 1;

        // 깊이 우선 탐색으로 경로 찾기
        dfs(0, 0);
        
        int result = can_move[0][0] == -1 ? 0 : can_move[0][0];
        System.out.println(result);
    }

    private static int dfs(int x, int y) {

        // 이미 경로가 정해진 위치라면 그대로 리턴
        if(can_move[x][y] != 0) return can_move[x][y];

        int nx, ny;
        int ret;
        boolean flag = false;
        for (int i = 0; i < 4; i++) { // 사방 탐색
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0 && nx < M && ny >= 0 && ny < N) { // 범위 체크
                if(map[nx][ny] < map[x][y]) { // 현재 위치보다 높이가 낮은 지점인지 확인

                    // 이미 갈 수 있다고 증명된 길일 경우
                    if(can_move[nx][ny] >= 1) {
                        can_move[x][y] += can_move[nx][ny];
                        flag = true;
                    }
                    // 아직 가보지 않은 길일 경우
                    else if(can_move[nx][ny] == 0){
                        ret = dfs(nx, ny);

                        if(ret >= 1) {
                            can_move[x][y] += ret;
                            flag = true;
                        }
                    }
                }
            }
        }

        // 현재 위치에서 가능한 경로를 찾았다면
        if(flag) {
            return can_move[x][y];
        }
        // 경로를 찾지 못했다면
        else {
            can_move[x][y] = -1;
            return -1;
        }
    }
}