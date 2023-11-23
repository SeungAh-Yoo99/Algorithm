import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 수열의 크기
        int N = Integer.parseInt(br.readLine());

        // A := 수열
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = 2;

        if(N < 3) result = N;
        else {
            // 수열 정렬
            Arrays.sort(A);

            // x < z, y < z일 때 x + y > z라면 x + z > y, y + z > x도 만족
            for (int i = 0; i < N - 1; i++) {
                int x = A[i];
                int y = A[i + 1];
                for (int j = i + 2; j < N; j++) {
                    int z = A[j];
                    if(x + y <= z) break;
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        System.out.println(result);
    }
}