import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        // 열린 괄호 개수 누적합
        int[] count = new int[arr.length];

        // 누적합이 1 이하인 지점의 개수 누적합
        int[] less = new int[arr.length];

        // 마이너스가 처음으로 나온 구간
        int end = -1;

        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                if(arr[0] == '(') {
                    count[0] = 1;
                }
                else {
                    count[0] = -1;
                    end = 0;
                }
                less[0] = 1;
                continue;
            }

            if(arr[i] == '(') {
                count[i] = count[i - 1] + 1;
            }
            else {
                count[i] = count[i - 1] - 1;
                if(count[i] < 0 && end == -1) end = i;
            }

            if(count[i] < 2) less[i] = less[i - 1] + 1;
            else less[i] = less[i - 1];
        }

        int result = 0;

        /**
        * 누적합이 마이너스가 나온 구간 이후에 괄호를 바꿔도
        * 앞에는 영향을 주지 못하기 때문에, 앞은 여전히 잘못된 괄호식이다.
        * 때문에 처음으로 나온 마이너스 구간까지만 괄호를 바꿔 올바른 식을 만들 수 있다.
        */
        for (int i = 0; i <= (end == -1 ? arr.length - 1 : end); i++) {
            if(arr[i] == ')') { // 닫힌 괄호를 열린 괄호로 바꾸는 경우
                /**
                 * i 이후의 모든 누적합이 + 2가 된다.
                 * 올바른 괄호식이 되기 위해서는 i 이후의 모든 누적합이 0 이상이며, 마지막 누적합이 0이어야 한다.
                 * -> 최대 한 번의 오타만 냈기 때문에 가장 작은 마이너스 값은 -2이고 +2면 무조건 0 이상이 된다.
                 * -> 따라서 마지막 누적합만 0인지 확인하면 된다.
                 */

                if(count[arr.length - 1] + 2 == 0) {
                    result++;
                }
            }
            else { // 열린 괄호를 닫힌 괄호로 바꾸는 경우
                /**
                 * i 이후의 모든 누적합이 -2가 된다.
                 * 올바른 괄호식이 되기 위해서는 i 이후의 모든 누적합이
                 * -2를 한 이후에도 0 이상이며, 마지막 누적합이 0이어야 한다.
                 */

                if((less[arr.length - 1] - (i == 0 ? 0 : less[i - 1])) == 0 && count[arr.length - 1] - 2 == 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}