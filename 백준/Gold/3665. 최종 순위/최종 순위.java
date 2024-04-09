import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int n, num, m, a, b;
        int[][] arr;
        Map<Integer, Integer> map;
        StringBuilder tmp;
        boolean flag;
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n + 1][2];
            arr[0][0] = n + 1;

            map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                num = Integer.parseInt(st.nextToken());
                arr[num][0] = i;
                arr[num][1] = num;

                map.put(num, i);
            }

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if(map.get(a) < map.get(b)) {
                    arr[a][0]++;
                    arr[b][0]--;
                }
                else {
                    arr[a][0]--;
                    arr[b][0]++;
                }
            }

            Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

            tmp = new StringBuilder();
            flag = false;
            for (int i = 0; i < n; i++) {
                if(arr[i][0] != i) {
                    result.append("IMPOSSIBLE\n");
                    flag = true;
                    break;
                }
                if(i != n - 1) tmp.append(arr[i][1] + " ");
                else tmp.append(arr[i][1]);
            }
            if(!flag) result.append(tmp + "\n");
        }

        System.out.print(result);
    }
}