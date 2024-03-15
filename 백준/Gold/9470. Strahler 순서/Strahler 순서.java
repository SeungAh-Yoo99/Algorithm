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
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int K, M, P, A, B, now, next, count;
        int[] in, order;
        ArrayList<ArrayList<Integer>> inList, outList;
        Queue<Integer> q;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            // 자신에게로 흘러들어오는 물 수
            in = new int[M + 1];

            // 자신에게로 흘러들어오는 물 리스트
            inList = new ArrayList<>();
            for (int i = 0; i <= M; i++) {
                inList.add(new ArrayList<>());
            }

            // 자신이 흘러가는 노드 리스트
            outList = new ArrayList<>();
            for (int i = 0; i <= M; i++) {
                outList.add(new ArrayList<>());
            }

            // 강의 순서
            order = new int[M + 1];

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());

                in[B]++;
                inList.get(B).add(A);
                outList.get(A).add(B);
            }

            // 위상 정렬
            q = new LinkedList<>();

            for (int i = 1; i <= M; i++) {
                if(in[i] == 0) { // 강의 근원인 경우
                    order[i] = 1;
                    q.add(i);
                }
            }

            while(!q.isEmpty()) {
                now = q.poll();

                for (int i = 0; i < outList.get(now).size(); i++) {
                    next = outList.get(now).get(i);

                    in[next]--;

                    // 자신에게 들어오는 물의 순서가 다 정해진 경우
                    if(in[next] == 0) {
                        
                        // next 노드의 순서 구하기
                        count = 0;
                        for (int j = 0; j < inList.get(next).size(); j++) {
                            if(order[next] == order[inList.get(next).get(j)]) count++;
                            else if(order[next] < order[inList.get(next).get(j)]) {
                                order[next] = order[inList.get(next).get(j)];
                                count = 1;
                            }
                        }
                        if(count > 1) order[next]++;

                        q.add(next);
                    }
                }
            }

            answer.append(K + " " + order[M] + "\n");
        }

        System.out.println(answer);
    }
}