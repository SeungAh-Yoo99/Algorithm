import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> resultList = new ArrayList<>(); // 만들 수 있는 물약 리스트(답 리스트)

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 위상 정렬

        ArrayList<ArrayList<int[]>> edges = new ArrayList<>(); // edges.get(i) := i번 물약을 재료로 가지고 있는 물약 리스트
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        ArrayList<ArrayList<Integer>> count = new ArrayList<>(); // count.get(i) := i번 물약을 만들기 위해 필요한 물약 개수
        for (int i = 0; i <= N; i++) {
            count.add(new ArrayList<>());
        }

        Queue<Integer> q = new ArrayDeque<>();
        int k, r;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }
            r = Integer.parseInt(st.nextToken());

            while(!q.isEmpty()) { // 재료 물약들에게 r 물약의 재료로 사용된다고 알려줌
                edges.get(q.poll()).add(new int[] {r, count.get(r).size()});
            }

            count.get(r).add(k); // r번 물약을 만들기 위해선 k개의 재료 물약이 필요함
        }

        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i = 0; i < L; i++) {
            tmp = Integer.parseInt(st.nextToken());
            q.add(tmp); // 이미 가지고 있는 물약
            count.get(tmp).clear(); // 이미 가지고 있으므로, 이 물약을 만들기 위해 더 이상 재료가 필요하지 않음
            resultList.add(tmp); // 답 리스트에 넣음
        }

        int now;
        int[] next;
        ArrayList<int[]> edge;
        while(!q.isEmpty()) {
            now = q.poll(); // 이미 가지고 있거나, 만들 수 있는 물약

            edge = edges.get(now); // now번 물약을 재료로 사용하는 물약 리스트
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(count.get(next[0]).isEmpty()) continue;

                // 필요한 재료 물약을 모두 가지게 되었다면, 이미 가지고 있는 물약 큐에 넣어줌
                tmp = count.get(next[0]).get(next[1]);
                if(tmp == 1) {
                    q.add(next[0]);
                    count.get(next[0]).clear();
                    resultList.add(next[0]);
                }
                else { // 아직 재료가 더 필요하면, 필요한 재료 개수만 줄여줌
                    count.get(next[0]).set(next[1], tmp - 1);
                }
            }
        }

        Collections.sort(resultList); // 답 리스트 정렬

        StringBuilder result = new StringBuilder();
        result.append(resultList.size()).append("\n");
        for (int i = 0; i < resultList.size(); i++) {
            result.append(resultList.get(i)).append(" ");
        }
        System.out.println(result);
    }
}