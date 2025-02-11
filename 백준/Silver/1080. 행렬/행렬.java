import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 행렬 A
        boolean[][] A = new boolean[N][M];

        char[] tmp;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(tmp[j] == '1') A[i][j] = true;
            }
        }

        // 행렬 B를 A에 합치기
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(tmp[j] == '1' && !A[i][j]) A[i][j] = true;
                else if(tmp[j] == '1' && A[i][j]) A[i][j] = false;
            }
        }

        int answer = 0;

        // 모든 원소를 false로 만들어주어야 함
        for (int i = 0; i <= N - 3; i++) {
            for(int j = 0; j<= M - 3; j++) {
                if(A[i][j]) {
                    answer++;
                    for(int k = 0; k < 3; k++)
                        for (int l = 0; l < 3; l++)
                            A[i + k][j + l] = !A[i + k][j + l];
                }
            }
        }

        // 모든 원소가 바뀌었는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}