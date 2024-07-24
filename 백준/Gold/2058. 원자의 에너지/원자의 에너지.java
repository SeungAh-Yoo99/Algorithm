import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static Set<Integer> state;
    static int[] energy;
    static Set<Integer> visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        state = new HashSet<>();
        for (int i = 0; i < N; i++) {
            state.add(Integer.parseInt(br.readLine()));
        }

        energy = new int[M];
        for (int i = 0; i < M; i++) {
            energy[i] = Integer.parseInt(br.readLine());
        }

        visited = new HashSet<>();

        int[] result = new int[2];
        int[] tmp;
        for(int now : state.toArray(new Integer[0])) {
            if(!visited.contains(now)) {
                tmp = dfs(now);
                result[0] = tmp[1];
                result[1] = Math.max(tmp[0], tmp[1]);
            }
        }
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