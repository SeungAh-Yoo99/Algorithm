import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 부메랑 모양
    static int[][][]  boomerang = {
            {{0, -1}, {1, 0}},
            {{-1, 0}, {0, -1}},
            {{-1, 0}, {0, 1}},
            {{0, 1}, {1, 0}}
    };

    static int N, M;
    static int[][] material;

    static boolean[][] visited;

    static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        material = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                material[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        result = 0;
        backtracking(0, 0, 0);

        System.out.println(result);
    }

    private static void backtracking(int x, int y, int cost) {

        // 한 가지 경우의 끝이라면
        if(x == N) {
            result = Math.max(result, cost);
            return;
        }

        // 현재 위치에 부메랑을 만들지 않는 경우
        backtracking(y == M - 1 ? x + 1 : x, y == M - 1? 0 : y + 1, cost);

        // 현재 위치가 이미 사용되었다면 이 경우는 더 이상 보지 않음
        if(visited[x][y]) return;

        // 현재 위치를 중심으로 부메랑을 만드는 경우
        int[][] boo;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            boo = boomerang[i];

            // 부메랑이 나무 재료 밖을 벗어나지 않을 경우
            if(x + boo[0][0] >= 0 && x + boo[0][0] < N && y + boo[0][1] >= 0 && y + boo[0][1] < M
            && x + boo[1][0] >= 0 && x + boo[1][0] < N && y + boo[1][1] >= 0 && y + boo[1][1] < M) {
                // 이미 사용된 위치가 아닐 경우
                if(!visited[x + boo[0][0]][y + boo[0][1]] && !visited[x + boo[1][0]][y + boo[1][1]]) {
                    visited[x + boo[0][0]][y + boo[0][1]] = true;
                    visited[x + boo[1][0]][y + boo[1][1]] = true;

                    backtracking(y == M - 1 ? x + 1 : x, y == M - 1? 0 : y + 1,
                            cost + material[x][y] * 2 + material[x + boo[0][0]][y + boo[0][1]] + material[x + boo[1][0]][y + boo[1][1]]);

                    visited[x + boo[0][0]][y + boo[0][1]] = false;
                    visited[x + boo[1][0]][y + boo[1][1]] = false;
                }
            }
        }
        visited[x][y] = false;
    }
}