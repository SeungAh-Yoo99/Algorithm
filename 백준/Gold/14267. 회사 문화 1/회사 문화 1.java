import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n := 직원 수, m := 칭찬의 횟수
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 관계
        ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relationship.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int boss = Integer.parseInt(st.nextToken()); // 1번 입력은 버림.
        for (int i = 2; i <= n; i++) {
            boss = Integer.parseInt(st.nextToken());
            relationship.get(boss).add(i);
        }

        // 칭찬
        int[] commend = new int[n + 1];

        int i, w;
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            commend[i] += w;
        }

        // 1번부터 부하들에게 칭찬 전달
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int now, next; ArrayList<Integer> list;
        while (!q.isEmpty()) {
            now = q.poll();

            // now의 부하 리스트
            list = relationship.get(now);
            for (int j = 0; j < list.size(); j++) {
                next = list.get(j);
                commend[next] += commend[now];
                q.add(next);
            }
        }

        // 출력
        StringBuilder answer = new StringBuilder();
        for (int j = 1; j <= n; j++) {
            answer.append(commend[j] + " ");
        }
        System.out.println(answer);
    }
}