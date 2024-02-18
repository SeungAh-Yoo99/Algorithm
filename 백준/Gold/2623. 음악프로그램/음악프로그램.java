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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 자신보다 먼저 나와야하는 가수 수
        int[] before = new int[N + 1];

        // 자신보다 뒤에 나와야 하는 가수 수
        ArrayList<ArrayList<Integer>> after = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            after.add(new ArrayList<>());
        }

        int t, b, a = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            if(t != 0) a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t - 1; j++) {
                b = Integer.parseInt(st.nextToken());

                before[b]++;
                after.get(a).add(b);
                a = b;
            }
        }

        int count = 0; // 순서가 정해진 가수 수
        StringBuilder answer = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        // 맨 처음 나와도 되는 가수들 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if(before[i] == 0) q.add(i);
        }

        int now, next;
        while (!q.isEmpty()) {
            now = q.poll();

            count++;
            answer.append(now + "\n");

            for (int i = 0; i < after.get(now).size(); i++) {
                next = after.get(now).get(i);
                before[next]--;
                if(before[next] == 0) q.add(next);
            }
        }

        // 모든 가수의 순서가 정해진 경우
        if(count == N) System.out.println(answer);
        // 순서를 다 정하지 못한 경우
        else System.out.println(0);
    }
}
