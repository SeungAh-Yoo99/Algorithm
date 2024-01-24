import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws Exception{

        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, -1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 수
        int T = Integer.parseInt(br.readLine());

        int N, nx, ny; char[][] map; int[][] minTime; int[] now;
        for (int tc = 1; tc <= T; tc++) {
            // N := 지도의 크기
            N = Integer.parseInt(br.readLine());

            // 지도 정보
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            // 최소 시간
            minTime = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(minTime[i], N * N);
            }
            minTime[0][0] = 0; // 시작점 초기화

            // DFS
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {0, 0, 0});

            while(!q.isEmpty()) {
                now = q.poll();

                // 사방탐색
                for (int i = 0; i < 4; i++) {
                    nx = dx[i] + now[0];
                    ny = dy[i] + now[1];

                    // 범위 확인
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if(minTime[nx][ny] > now[2] + map[nx][ny] - '0') { // 더 짧은 경우를 찾았다면
                            minTime[nx][ny] = now[2] + map[nx][ny] - '0';
                            q.add(new int[] {nx, ny, minTime[nx][ny]});
                        }
                    }
                }
            }

            // 답 저장
            answer.append("#" + tc + " " + minTime[N - 1][N - 1] + "\n");
        }

        // 출력
        System.out.println(answer);
    }
}