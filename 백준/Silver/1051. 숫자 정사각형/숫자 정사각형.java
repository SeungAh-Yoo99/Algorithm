import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] numbers = new char[N][];
        for(int i = 0; i < N; i++) {
            numbers[i] = br.readLine().toCharArray();
        }

        int answer = 1;
        for(int i = 2; i <= N; i++) { // 길이가 i인 정사각형 찾기
            for(int k = 0; k <= N - i; k++) { // 정사각형의 왼쪽 위 x 좌표
                for(int l = 0; l <= M - i; l++) { // 정사각형의 왼쪽 위 y 좌표
                    if(numbers[k][l] == numbers[k][l + i - 1]
                    && numbers[k][l] == numbers[k + i - 1][l]
                    && numbers[k][l] == numbers[k + i - 1][l + i - 1])
                        answer = Math.max(answer, i * i);
                }
            }
        }

        System.out.println(answer);
    }
}