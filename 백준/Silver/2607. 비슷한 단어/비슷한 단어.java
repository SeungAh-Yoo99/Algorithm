import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 기준이 되는 문자열
        char[] first = br.readLine().toCharArray();

        // 기준 문자열 알파벳 개수 저장
        int[] firstCount = new int['Z' - 'A' + 1];
        for (int i = 0; i < first.length; i++) {
            firstCount[first[i] - 'A']++;
        }

        int result = 0;

        char[] compare; int[] count; int diff;
        for (int i = 1; i < n; i++) {

            count = firstCount.clone();

            // 다른 단어 개수
            diff = 0;

            // 비교 문자열
            compare = br.readLine().toCharArray();

            // 문자열 길이가 2 이상 차이나면 안됨
            if(Math.abs(first.length - compare.length) >= 2) continue;

            for (int j = 0; j < compare.length; j++) {
                // 현재 단어가 first에 포함되어 있음
                if(count[compare[j] - 'A'] > 0) count[compare[j] - 'A']--;
                else diff++;
            }

            // 기준 문자열이 더 길다면, 다른 단어가 있으면 안됨
            if(compare.length < first.length) {
                if(diff == 0) result++;
            } else { // 문자열 길이가 같거나, 비교 문자열이 더 길다면
                if(diff <= 1) result++;
            }
        }


        System.out.println(result);
    }
}