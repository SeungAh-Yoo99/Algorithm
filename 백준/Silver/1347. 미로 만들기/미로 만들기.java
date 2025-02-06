import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String cmd = br.readLine();

        // 상하좌우로 움직인 최대 거리
        int up = 0, down = 0, left = 0, right = 0;

        // 움직인 칸을 담을 리스트
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {0, 0});

        // 남서북동
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        // 현재 방향, 좌표
        int d = 0, x = 0, y = 0;

        char c;
        for (int i = 0; i < length; i++) {
            c = cmd.charAt(i);

            if(c == 'F') {
                // 이동
                x += dx[d];
                y += dy[d];

                // 맵 크기 갱신
                up = Math.min(up, x);
                down = Math.max(down, x);
                left = Math.min(left, y);
                right = Math.max(right, y);

                list.add(new int[] {x, y});
            }
            else if(c == 'L') d = d - 1 < 0 ? 3 : d - 1;
            else if(c == 'R') d = d + 1 > 3 ? 0 : d + 1;
        }

        // 이동 범위만큼의 지도 생성
        boolean[][] map = new boolean[down - up + 1][right - left + 1];

        // 이동할 수 있는 칸 표시
        for(int[] p : list) {
            map[p[0] - up][p[1] - left] = true;
        }

        // 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for(boolean m : map[i]) {
                if(m) answer.append(".");
                else answer.append("#");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}