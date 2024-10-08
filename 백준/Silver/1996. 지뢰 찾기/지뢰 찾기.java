import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 팔방탐색
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        StringBuilder result = new StringBuilder();

        int nx, ny, count;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '.') { // 지뢰가 없는 경우 팔방탐색으로 주변의 지뢰 개수 알아내기
                    count = 0;
                    for (int k = 0; k < 8; k++) { // 팔방탐색
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 확인
                            if(map[nx][ny] != '.') { // 지뢰가 있는 경우
                                count += map[nx][ny] - '0';
                            }
                        }
                    }

                    if(count >= 10) result.append("M");
                    else result.append(count);
                }
                else { // 지뢰인 경우
                    result.append("*");
                }
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}