import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 자기보다 큰 사람 중 아직 줄을 서지 않은 사람 수를 담을 배열
        int[] pre = new int[N + 1];

        // 자기보다 큰 사람이 모두 줄은 슨 사람을 담을 큐
        // 우선 순위 큐로 항상 작은 사람이 앞에 올 수 있도록 해줌
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pre[i] = Integer.parseInt(st.nextToken());
            if(pre[i] == 0) queue.add(i);
        }

        // 정답 리스트
        List<Integer> list = new ArrayList<>();

        // 위상 정렬
        int now;
        while(!queue.isEmpty()) {
            now = queue.poll();
            list.add(now);

            // now보다 뒤에 있는 사람들 중, now보다 작은 키를 가진 사람들의 pre를 1 씩 줄여준다
            for (int i = 1; i < now; i++) {
                if(pre[i] == 1) queue.add(i);
                pre[i]--;
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int l : list) answer.append(l).append(" ");
        System.out.println(answer);
    }
}