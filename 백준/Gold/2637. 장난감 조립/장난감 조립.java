import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] status;
    static ArrayList<int[]> parts;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        // 0 := 기본 부품
        // 1 := 중간 부품 (필요한 기본 부품 계산 x)
        // 2 := 중간 부품 (필요한 기본 부품 계산 o)
        status = new int[N + 1];

        parts = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            parts.add(new int[N + 1]);
        }

        int X, Y, K;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            status[X] = 1;
            parts.get(X)[Y] = K;
        }

        // 완제품 조립에 필요한 부품수 구하기
        StringBuilder result = new StringBuilder();
        if(status[N] == 0) result.append(N + " 1\n");
        else {
            getPartNum(N);
            for (int i = 1; i <= N; i++) {
                if(status[i] == 0 && parts.get(N)[i] > 0) result.append(i + " " + parts.get(N)[i] + "\n");
            }
        }
        System.out.println(result);
    }

    private static void getPartNum(int no) {

        int[] part = parts.get(no);

        for (int i = 1; i <= N; i++) {
            if(part[i] > 0) {
                if(status[i] == 1) {
                    getPartNum(i);
                }
                if(status[i] == 2) {
                    for (int j = 1; j <= N; j++) {
                        if(status[j] == 0) part[j] += part[i] * parts.get(i)[j];
                    }
                }
            }
        }

        status[no] = 2;
    }
}