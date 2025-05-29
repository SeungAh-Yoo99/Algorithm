import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 파이프 정보
        int[][] pipes = new int[P][2];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            pipes[i][0] = Integer.parseInt(st.nextToken());
            pipes[i][1] = Integer.parseInt(st.nextToken());
        }

        // 파이프 용량을 기준으로 내림차순 정렬
        Arrays.sort(pipes, (o1, o2) -> o2[1] - o1[1]);

        // 최대 용량
        int[] max_size = new int[D + 1];

        // 이전 파이프까지 사용했을 때의 경우의 수들을 담은 큐
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 이번 파이프까지 사용했을 때의 경우의 수들을 담은 큐
        ArrayDeque<int[]> tmp;

        int[] pipe, t;
        for (int i = 0; i < P; i++) {

            pipe = pipes[i];
            if(pipe[0] > D) continue;
            if(pipe[0] == D) {
                System.out.println(pipe[1]);
                return;
            }

            tmp = new ArrayDeque<>();

            // 이전 파이프까지 사용했을 때의 경우의 수들을 하나씩 확인
            while(!queue.isEmpty()) {
                t = queue.pollFirst();

                // 현재 파이프를 사용했을 때, D 길이의 파이프를 조합할 수 있는 경우
                if(t[0] + pipe[0] == D) {
                    System.out.println(pipe[1]);
                    return;
                }

                // 큐에서도 용량이 큰 파이프 순으로 담길 수 있도록 넣어준다
                tmp.add(t);

                // 현재 파이프를 연결했을 때, 최대 용량인 경우라면 큐에 넣어줌
                if(t[0] + pipe[0] < D && max_size[t[0] + pipe[0]] == 0) {
                    max_size[t[0] + pipe[0]] = pipe[1];
                    tmp.add(new int[] {t[0] + pipe[0], pipe[1]});
                }
            }

            // 현재 파이프가 처음 나온 길이일 때
            if(max_size[pipe[0]] == 0) {
                max_size[pipe[0]] = pipe[1];
                tmp.add(pipe);
            }

            queue = tmp;
        }
    }
}
