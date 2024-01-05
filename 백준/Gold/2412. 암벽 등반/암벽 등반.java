import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n := 홈의 개수, T := 정상 높이
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 홈 정보
        Map<Integer, Map<Integer, Integer>> point = new HashMap<>();
        Map<Integer, Integer> tmp;
        int s, e;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            tmp = point.get(s);
            if(tmp == null) { // 아직 x좌표가 s인 홈이 없었다면
                tmp = new HashMap<>();
                tmp.put(e, i);
                point.put(s, tmp);
            }
            else {
                tmp.put(e, i);
            }
        }

        // bfs로 최소 이동 횟수 구하기
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0}); // x좌표, y좌표, 이동 횟수

        boolean[] visited = new boolean[n]; // 한 번  방문한 홈은 다시 방문하지 않음

        int[] now; Map<Integer, Integer> nextYList; Integer nextIdx;
        while(!q.isEmpty()) {
            now = q.poll();

            // now에서 이동할 수 있는 범위의 홈 찾기
            for (int i = now[0] - 2; i <= now[0] + 2; i++) { // 이동할 수 있는 x좌표 범위

                nextYList = point.get(i);
                if(nextYList != null) { // x좌표가 i인 홈이 있다면

                    for (int j = now[1] - 2; j <= now[1] + 2; j++) { // 이동할 수 있는 y좌표 범위

                        nextIdx = nextYList.get(j);
                        if(nextIdx != null) { // y좌표가 j인 홈이 있다면

                            if(j == T) { // 정상에 도착
                                System.out.println(now[2] + 1);
                                return; // 종료
                            }

                            if(!visited[nextIdx]) { // 이동 가능한 홈이 방문한 적 없다면
                                visited[nextIdx] = true;
                                q.add(new int[] {i, j, now[2] + 1});
                            }
                        }
                    }
                }
            }
        }

        // 여기까지 온 경우 정상에 오를 수 없는 경우
        System.out.println(-1);
    }
}