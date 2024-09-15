import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 문자 순서대로 몇 번 자판에 있는지
    static int[] number = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
    // 문자 순서대로 해당 자판을 몇 번 눌러야 하는지
    static int[] order = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] strArr = br.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < strArr.length; i++) {

            // 공백인 경우
            if(strArr[i] == ' ') {
                result += p;
                continue;
            }

            // 해당 문자를 입력하기 위해서 자판을 누를 횟수만큼 걸리는 시간
            result += p * order[strArr[i] - 'A'];
            // 만약 앞 문자가 현재 문자와 같은 자판에 있는 문자라면, w 시간만큼 기다려야 함
            if(i > 0 && strArr[i - 1] != ' ' &&
                    number[strArr[i - 1] - 'A'] == number[strArr[i] - 'A']) result += w;
        }

        System.out.println(result);
    }
}