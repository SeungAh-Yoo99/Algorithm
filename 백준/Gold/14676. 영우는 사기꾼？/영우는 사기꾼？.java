import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // index가 건설 상태여야 건설할 수 있는 건물 리스트
        ArrayList<ArrayList<Integer>> preList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            preList.add(new ArrayList<>());
        }

        // 필요한 선행 건물 개수
        int[] pre = new int[N + 1];

        int X, Y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            preList.get(X).add(Y);
            pre[Y]++;
        }

        // 건물 개수
        int[] num = new int[N + 1];

        int c, a;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            if(c == 1) {
                // 선행 건물이 다 지어지지 않은 경우
                if(pre[a] != 0) {
                    System.out.println("Lier!");
                    return;
                }

                // 건물이 하나도 없었던 경우
               if(num[a] == 0) {
                   for (int j = 0; j < preList.get(a).size(); j++) {
                       pre[preList.get(a).get(j)]--;
                   }
               }

               num[a]++;
            }
            else {
                // 건물이 없는 경우
                if(num[a] == 0) {
                    System.out.println("Lier!");
                    return;
                }

                // 마지막 건물이었을 경우
                if(num[a] == 1) {
                    for (int j = 0; j < preList.get(a).size(); j++) {
                        pre[preList.get(a).get(j)]++;
                    }
                }

                num[a]--;
            }
        }

        System.out.println("King-God-Emperor");
    }
}