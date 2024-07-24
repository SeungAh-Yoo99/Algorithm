import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * A -> B로 변할 수 있는 방법은 한 가지 뿐이라는 점에서 트리인 것을 알 수 있다.
 *
 * N개의 에너지 상태가 주어지므로, 노드는 N개
 * 만약 노드 A에서 양성자 중 하나를 더하거나 빼서 노드 B값이 나오면 두 노드는 간선으로 연결된 것(A->B)
 * 모든 노드들이 하나의 트리로 연결된 것은 아님.
 * 여러 개의 트리에 나눠 연결되어 있을 수 있다.
 *
 * 간선으로 연결된 두 개의 노드는 함께 컨테이너에 집어넣을 수 없음
 * DP를 통해 현재 노드를 넣거나 뺀 경우 중 더 나은 경우를 구해야함
 */
public class Main {

    static int M;
    static Set<Integer> state;
    static int[] energy;
    static Set<Integer> visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원자 상태의 개수
        M = Integer.parseInt(st.nextToken()); // 양성자의 개수

        // 원자가 가질 수 있는 에너지 상태
        state = new HashSet<>();
        int start = 0, n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());

            if(i == 0) start = n;
            state.add(n);
        }

        // 양성자가 가진 에너지
        energy = new int[M];
        for (int i = 0; i < M; i++) {
            energy[i] = Integer.parseInt(br.readLine());
        }

        // 노드 방문 체크
        visited = new HashSet<>();

        // result[0] := now을 포함했을 경우의 최대값
        // result[1] := now을 포함하지 않았을 경우의 최대값
        int[] result = dfs(start);
        System.out.println(Math.max(result[0], result[1]));
    }

    private static int[] dfs(int n) { // n := 현재 상태

        // a -> b -> c -> b -> a와 같은 순환구조를 막기 위해 방문체크
        visited.add(n);

        // result[0] := n을 포함했을 경우의 최대값
        // result[1] := n을 포함하지 않았을 경우의 최대값
        int[] result = new int[2];
        result[0] = n;

        int[] tmp;
        for (int i = 0; i < M; i++) {
            // 양성자를 받아들이거나 내쏘아서 만들 수 있는 새로운 원자
            for(int newState : new int[] {n + energy[i], n - energy[i]}) {
                if(newState > 0) {
                    if(state.contains(newState) && !visited.contains(newState)) { // 만들 수 있는 상태라면
                        tmp = dfs(newState);
                        // newState들을 포함하지 않았을 경우의 최대값
                        result[0] += tmp[1];
                        // newState를 포함하거나 포함하지 않았을 때 중 최대값
                        result[1] += Math.max(tmp[0], tmp[1]);
                    }
                }
            }
        }

        return result;
    }
}