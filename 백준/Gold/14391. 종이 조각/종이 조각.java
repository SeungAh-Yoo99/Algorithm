import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;

    static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 세로 크기, M := 가로 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 종이 조각에 쓰여있는 숫자 입력
        paper = new int[N][M];
        char[] tmp;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                paper[i][j] = tmp[j] - '0';
            }
        }

        // 종이 자르는 경우를 모두 구해보며 최대값 구하기
        result = 0;
        divide(0, 0, N - 1, 0, M - 1);

        // 출력
        System.out.println(result);
    }

    private static void divide(int sum, int rs, int re, int cs, int ce) {
        
        /*
        현재 범위에서 한 조각을 자르고, 잘린 조각만큼 범위에서 빼주고 재귀
        
        현재 한 조각을 자를 때, 자를 수 있을 만큼 길게 자르는게 유리하다.
        따라서 (맨 위 가로, 맨 밑 가로, 왼쪽 세로, 오른쪽 세로) 중 한 방향을 정해 중간에서 조각내지 않고 통으로 자른 후,
        다음 조각을 자르러 재귀해준다.
         */
        

        if(rs == re || cs == ce) { // 종이를 다 잘랐다면
            result = Math.max(result, sum + getNum(rs, re, cs, ce)); // 답 갱신
            return;
        }

        // 조각의 맨 위 가로 통째로 자르는 경우
        divide(sum + getNum(rs, rs, cs, ce), rs + 1, re, cs, ce);

        // 조각의 맨 밑 가로 통째로 자르는 경우
        divide(sum + getNum(re, re, cs, ce), rs, re - 1, cs, ce);

        // 조각의 왼쪽 세로 통째로 자르는 경우
        divide(sum + getNum(rs, re, cs, cs), rs, re, cs + 1, ce);

        // 조각의 오른쪽 세로 통째로 자르는 경우
        divide(sum + getNum(rs, re, ce, ce), rs, re, cs, ce - 1);
    }

    private static int getNum(int rs, int re, int cs, int ce) { // 조각 범위를 넣으면 범위 내의 수를 이어붙인 값 리턴

        int ret = 0;

        if(rs == re) { // 가로 조각인 경우
            for (int i = cs; i <= ce; i++) {
                ret = ret * 10 + paper[rs][i];
            }
        }
        else { // 세로 조각인 경우
            for (int i = rs; i <= re; i++) {
                ret = ret * 10 + paper[i][cs];
            }
        }

        return ret;
    }
}