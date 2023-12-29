import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 구사과가 고른 문자
        char[] string1 = br.readLine().toCharArray();

        // 큐브러버가 고른 문자
        char[] string2 = br.readLine().toCharArray();

        // 정렬
        Arrays.sort(string1);
        Arrays.sort(string2);

        // 투 포인트
        int s1 = 0, e1 = string1.length / 2 + string1.length % 2 - 1;
        int s2 = e1 + 1, e2 = string2.length - 1;
        int rs = 0, re = string1.length - 1;

        char[] result = new char[string1.length];
        int i = 0;
        while(i++ < string1.length) {

            if(i % 2 == 1) { // 구사과 차례
                if(string1[s1] < string2[e2]) { // 구사과 문자 중 가장 작은 것이 가장 앞에 오는 것이 제일 유리
                    result[rs++] = string1[s1++];
                } else { // 구사과 문자 중 가장 작은 것이 큐브러버 문자 중 가장 큰 것보다 크다면, 구사과 문자 중 가장 큰 것이 가장 마지막에 가야 유리
                    result[re--] = string1[e1--];
                }
            } else { // 큐브러버 차례
                if(string1[s1] < string2[e2]) { // 큐브러버 문자 중 가장 큰 것이 기장 앞에 오는 것이 제일 유리
                    result[rs++] = string2[e2--];
                } else { // 큐브러버 문자 중 가장 큰 것이 구사과 문자 중 가장 작은 것보다 작다면, 큐브러버 문자 중 가장 작은 것이 가장 마지막에 가야 유리
                    result[re--] = string2[s2++];
                }
            }
        }

        // 출력
        StringBuilder resultSb = new StringBuilder();
        for (int j = 0; j < result.length; j++) {
            resultSb.append(result[j]);
        }
        System.out.println(resultSb);
    }
}