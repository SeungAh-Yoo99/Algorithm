import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 나중에 풀어야 하는 과목 리스트
        ArrayList<ArrayList<Integer>> outList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            outList.add(new ArrayList<>());
        }

        // 위상 정렬을 위한 진입 차수 저장 배열(선행 과목 개수)
        int[] indegree = new int[N + 1];

        int A, B;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            outList.get(A).add(B);
            indegree[B]++;
        }

        // 위상 정렬로 문제 풀이 순서 구하기
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 먼저 진입 차수가 0인 과목들 먼저 큐에 넣어주기
        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) pq.add(i);
        }

        // 큐에서 하나씩 꺼내며 위상 정렬
        int now, next;
        ArrayList<Integer> list;
        while(!pq.isEmpty()) {
            now = pq.poll();
            answer.append(now + " ");

            // now를 푼 다음 풀 수 있는 과목 리스트
            list = outList.get(now);
            for (int i = 0; i < list.size(); i++) {
                next = list.get(i);
                indegree[next]--;

                // next도 이제 풀 수 있다면 pq에 넣어줌
                if(indegree[next] == 0) pq.add(list.get(i));
            }
        }

        System.out.println(answer);
    }

}