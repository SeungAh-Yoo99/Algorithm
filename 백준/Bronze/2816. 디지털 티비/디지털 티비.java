import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String[] chanel;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        chanel = new String[N];
        for (int i = 0; i < N; i++) {
            chanel[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();

        // KBS1 찾기
        int index = 0;
        while(!chanel[index].equals("KBS1")) {
            index++;
            result.append("1");
        }

        // KBS1 맨 위로 올리기
        while(index > 0) {
            swap(index, index - 1);
            index--;
            result.append("4");
        }

        // KBS1 찾기
        while(!chanel[index].equals("KBS2")) {
            index++;
            result.append("1");
        }

        // KBS2 맨 위로 올리기
        while(index > 1) { // 실제로 바꾸진 않음
            index--;
            result.append("4");
        }

        System.out.println(result);
    }

    private static void swap(int a, int b) { // arr의 a 인덱스와 b 인덱스를 서로 바꿈

        String tmp = chanel[a];
        chanel[a] = chanel[b];
        chanel[b] = tmp;
    }
}