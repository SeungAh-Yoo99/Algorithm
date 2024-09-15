import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min, max;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        // A의 최솟값, 최댓값 구하기
        min = Integer.MAX_VALUE; max = 0;
        bfs(A, 0, 0);

        // 최솟값, 최댓값 저장
        int minSum = min, maxSum = max;

        // B의 최솟값, 최댓값 구하기
        min = Integer.MAX_VALUE; max = 0;
        bfs(B, 0, 0);

        // 최솟값, 최댓값 저장
        minSum += min;
        maxSum += max;

        // 출력
        System.out.println(minSum + " " + maxSum);
    }

    private static void bfs(char[] arr, int idx, int num) {

        if(arr.length == idx) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        if(arr[idx] == '5' || arr[idx] == '6') {
            bfs(arr, idx + 1, num * 10 + 5);
            bfs(arr, idx + 1, num * 10 + 6);
        }
        else bfs(arr, idx + 1, num * 10 + (arr[idx] - '0'));
    }
}