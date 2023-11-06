import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        // N := 지도 세로 크기, M := 지도 가로 크기, (x, y) := 주사위를 놓은 곳의 좌표, K := 명령의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 지도
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 주사위 정보
        // dice[0][1] ~ dice[0][6] := 주사위의 각 칸에 저장된 숫자
        // dice[1][1] := 현재 주사위의 동쪽에 위치한 면
        // dice[1][2] := 현재 주사위의 서쪽에 위치한 면
        // dice[1][3] := 현재 주사위의 북쪽에 위치한 면
        // dice[1][4] := 현재 주사위의 남쪽에 위치한 면
        // dice[1][5] := 현재 주사위의 위쪽에 위치한 면
        // dice[i][6] := 현재 주사위의 아래쪽에 위치한 면
        int[][] dice = new int[2][];
        dice[0] = new int[] {0, 0, 0, 0, 0, 0, 0};
        dice[1] = new int[] {0, 3, 4, 5, 2, 1, 6};

        // 명령
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int c = Integer.parseInt(st.nextToken());

            // 지도를 벗어날 수 없음
            if((c == 1 && y == M - 1) || (c == 2 && y == 0) || (c == 3 && x == 0) || (c == 4 && x == N - 1)) continue;

            // 좌표 바꾸기
            if(c == 1) y += 1;
            else if(c == 2) y -= 1;
            else if(c == 3) x -= 1;
            else x += 1;

            // 면 바꾸기
            int[] tmp = new int[7];
            if(c == 1) { // 동쪽 이동
                // (동 -> 밑, 위 -> 동, 서 -> 위, 밑 -> 서)로 이동
                tmp[6] = dice[1][1];
                tmp[1] = dice[1][5];
                tmp[5] = dice[1][2];
                tmp[2] = dice[1][6];
                // 북, 남은 고정
                tmp[3] = dice[1][3];
                tmp[4] = dice[1][4];
            } else if(c == 2) { // 서쪽 이동
                // (동 -> 위, 위 -> 서, 서 -> 밑, 밑 -> 동)로 이동
                tmp[5] = dice[1][1];
                tmp[2] = dice[1][5];
                tmp[6] = dice[1][2];
                tmp[1] = dice[1][6];
                // 북, 남은 고정
                tmp[3] = dice[1][3];
                tmp[4] = dice[1][4];
            } else if(c == 3) { // 북쪽 이동
                // (위 -> 북, 북 -> 밑, 밑 -> 남, 남 -> 위)로 이동
                tmp[3] = dice[1][5];
                tmp[6] = dice[1][3];
                tmp[4] = dice[1][6];
                tmp[5] = dice[1][4];
                // 동, 서는 고정
                tmp[1] = dice[1][1];
                tmp[2] = dice[1][2];
            } else { // 남쪽 이동
                // (위 -> 남, 북 -> 위, 밑 -> 북, 남 -> 밑)로 이동
                tmp[4] = dice[1][5];
                tmp[5] = dice[1][3];
                tmp[3] = dice[1][6];
                tmp[6] = dice[1][4];
                // 동, 서는 고정
                tmp[1] = dice[1][1];
                tmp[2] = dice[1][2];
            }
            dice[1] = tmp;

            if(map[x][y] == 0) { // 이동한 칸에 쓰여있는 수가 0이면
                map[x][y] = dice[0][dice[1][6]]; // 주사위의 바닥면에 쓰여 있는 수 칸에 복사
            } else { // 0이 아닐 경우
                dice[0][dice[1][6]] = map[x][y]; // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
                map[x][y] = 0;
            }

            // 윗 면에 쓰여 있는 수 출력
            result.append(dice[0][dice[1][5]] + "\n");
        }

        System.out.println(result);
    }
}