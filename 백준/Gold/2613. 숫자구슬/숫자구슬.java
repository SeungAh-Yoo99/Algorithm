import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        // 이분 탐색
        int result = 30_001;
        ArrayList<Integer> list, resultList = new ArrayList<>();
        int count, sum, idx, len;
        int s = max, e = 30_000, m;
        while(s <= e) {
            m = (s + e) / 2;

            // 합이 m 이하가 되도록 그룹을 나눴을 때, 그룹의 수가 M개 이하인지 확인
            list = new ArrayList<>();
            count = 1; idx = 0;
            sum = 0; len = 0;
            while(idx < N) {

                if(sum + arr[idx] > m) {
                    list.add(len);

                    len = 1;
                    sum = arr[idx];

                    count++;
                }
                else {
                    sum += arr[idx];
                    len++;
                }

                if(count > M) break;

                idx++;
            }
            list.add(len);

            if(count == M) {
                result = m;
                resultList = list;
                e = m - 1;
            }
            else if(count < M) {
                result = m;
                resultList = list;
                for (int i = 0; i < list.size(); i++) {
                    while(list.get(i) > 1 && count < M) {
                        list.set(i, list.get(i) - 1);
                        list.add(i + 1, 1);
                        count++;
                    }
                    if(count == M) break;
                }
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(result + "\n");
        for (int i = 0; i < resultList.size(); i++) {
            answer.append(resultList.get(i) + " ");
        }
        System.out.println(answer);
    }
}