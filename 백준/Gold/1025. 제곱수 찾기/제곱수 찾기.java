import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    static char[][] map;
    static ArrayList<ArrayList<int[]>> position;
    static char[] nnumToCharArray;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n := 행, m := 열
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

         // 0~9까지의 수의 좌표를 담을 ArrayList
        position = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            position.add(new ArrayList<>());
        }

        // 표에 적힌 숫자 입력
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();;
            for (int j = 0; j < m; j++) {
                position.get(map[i][j] - '0').add(new int[] {i, j}); // 수에 해당하는 인덱스의 ArrayList에 좌표값 넣어줌
            }
        }

        int num = (int)Math.sqrt(999_999_999); // 만들 수 있는 가장 큰 완전 제곱수의 제곱근
        Integer nnum; // num을 제곱한 완전 제곱수
        int result = -1;
        while(num >= 0) {
            nnum = num * num;

            nnumToCharArray = nnum.toString().toCharArray();

            // nnum을 만들 수 있는지 확인
            if(find(0, null, null)) { // nnum을 성립하는 등차수열을 찾았다면
                result = nnum;
                break;
            } else { // 못찾았다면 다음으로 작은 완전 제곱수 찾으러
                num--;
            }
        }

        // 출력
        System.out.println(result);
    }

    private static boolean find(int i, int[] prePosition, int[] sub) { // i := 몇 번째 자리수인지, prePosition := 앞자리 수의 위치, sub := 앞자리 수의 위치와 떨어져있어야 하는 위치


        // 여기까지 왔다는 것은 모든 수가 규칙에 맞게 존재하는 것
        if(i == nnumToCharArray.length) return true;

        boolean ret = false;

        ArrayList<int[]> now = position.get(nnumToCharArray[i] - '0');

        if(i == 0) { // 첫 번째 자리수일 경우
            for (int j = 0; j < now.size(); j++) {
                ret = find(i + 1, now.get(j), null); // 현재 위치만 담아 다음 위치 확인하러
                if(ret) break;
            }
        }
        else if(i == 1) { // 두 번째 자리수일 경우
            for (int j = 0; j < now.size(); j++) {
                ret = find(i + 1, now.get(j), new int[] {now.get(j)[0] - prePosition[0], now.get(j)[1] - prePosition[1]}); // 전 위치와의 차이도 담아 다음 위치 확인하러
                if(ret) break;
            }
        }
        else { // 세 번째 자리수부터는 등차수열을 이루고 있는지 확인
            int x = prePosition[0] + sub[0]; // 등차수열을 이루기 위해 현재 자릿수가 위치해야 할 x값
            int y = prePosition[1] + sub[1]; // 등차수열을 이루기 위해 현재 자릿수가 위치해야 할 y값

            if(x >= 0 && x < n && y >= 0 && y < m) { // 애초에 x, y가 범위 값을 넘어가면 성립하지 않음
                if(map[x][y] == nnumToCharArray[i]) ret = find(i + 1, new int[] {x, y}, sub); // (x, y)에 해당 자릿수가 있으면 다음 자리 검사하러
            }
        }

        return ret;
    }
}