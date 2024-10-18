import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 가장 긴 증가하는 부분 수열(LIS)
        LinkedList<Integer> lis = new LinkedList<>();
        lis.add(arr[0]);

        int s, e, m, tmp;
        for (int i = 1; i < N; i++) {

            // lis의 마지막 원소보다 더 크다면 바로 넣어줌
            if(lis.get(lis.size() - 1) < arr[i]) lis.add(arr[i]);
            else {
                // 이분 탐색 -> arr[i]보다 큰 수 중 가장 작은 수 구하기
                s = 0; e = lis.size() - 1; tmp = 0;
                while(s <= e) {
                    m = (s + e) / 2;

                    if(lis.get(m) > arr[i]) {
                        tmp = m;
                        e = m - 1;
                    } else s = m + 1;
                }

                // 이분 탐색으로 찾은 자리에 arr[i]를 대신 넣어줌
                lis.set(tmp, arr[i]);
            }
        }

        // 가장 긴 증가하는 부분 수열은 고정
        // 이외의 수들은 자리를 옮겨야 함
        System.out.println(N - lis.size());
    }
}