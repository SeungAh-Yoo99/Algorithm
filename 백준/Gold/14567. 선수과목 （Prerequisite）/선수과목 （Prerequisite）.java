import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> preSubject;
    static int[] preNum;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 과목의 수, M := 선수 조건의 수
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 선수 과목
        preSubject = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            preSubject.add(new ArrayList<>());
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            preSubject.get(b).add(a);
        }

        // 선수 과목 개수
        preNum = new int[N + 1];
        Arrays.fill(preNum, -1);

        // 과목별로 선수 과목 개수 구하기
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(getPresubject(i));
            if(i != N) answer.append(" ");
        }

        System.out.println(answer);
    }


    private static int getPresubject(int num) {

        ArrayList<Integer> pre = preSubject.get(num);

        int ret = 0, p;
        for (int i = 0; i < pre.size(); i++) {
            p = pre.get(i);

            // 과목 p의 선수 과목을 아직 구하지 않았다면 구하기
            if(preNum[p] == -1) ret = Math.max(ret, getPresubject(p));
            // 구했다면 대수 비교
            else ret = Math.max(ret, preNum[p]);
        }

        preNum[num] = ret + 1;

        return preNum[num]; // 자기 자신까지 포함시켜 리턴
    }
}