import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M := 세로 길이, N := 가로 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 갤러리 정보
        char[][] map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;

        int len1 = 0, len2 = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N; j++) {
                // 가로줄 윗 칸이 벽 & 아랫 칸이 빈 공간인 칸 구하기
                if(map[i][j] == 'X' && map[i + 1][j] == '.') len1++;
                else {
                    result += len1 / 2;
                    len1 = 0;
                }
                // 가로줄 아랫 칸이 벽 & 윗 칸이 빈 공간인 칸 구하기
                if(map[i][j] == '.' && map[i + 1][j] == 'X') len2++;
                else {
                    result += len2 / 2;
                    len2 = 0;
                }
            }
        }

        len1 = 0; len2 = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                // 세로줄 왼쪽 칸이 벽 & 오른쪽 칸이 빈 공간인 칸 구하기
                if(map[j][i] == 'X' && map[j][i + 1] == '.') len1++;
                else {
                    result += len1 / 2;
                    len1 = 0;
                }
                // 세로줄 왼쪽 칸이 빈 공간 & 오른쪽 칸이 벽인 칸 구하기
                if(map[j][i] == '.' && map[j][i + 1] == 'X') len2++;
                else {
                    result += len2 / 2;
                    len2 = 0;
                }
            }
        }

        // 출력
        System.out.println(result);
    }
}