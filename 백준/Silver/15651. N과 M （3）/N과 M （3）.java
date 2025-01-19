import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] combi;
    static StringBuilder answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combi = new int[M];
        answer = new StringBuilder();
        backTracking(0);

        System.out.print(answer);
    }

    private static void backTracking(int index) {

        if(index == M) {
            for(int c : combi) answer.append(c).append(" ");
            answer.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            combi[index] = i;
            backTracking(index + 1);
        }
    }
}