import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] table = new char[R][C];
        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().toCharArray();
        }

        // 열 별로 StringBuilder에 담아 문자열을 만들어줌
        StringBuilder[] arr = new StringBuilder[C];
        for (int i = 0; i < C; i++) {
            arr[i] = new StringBuilder();
            for (int j = 0; j < R; j++) {
                arr[i].append(table[j][i]);
            }
        }

        int count = 0;
        HashSet<String> hs;
        boolean flag;
        while(true) {
            hs = new HashSet<>();
            flag = false;

            for (int i = 0; i < C; i++) {
                arr[i].delete(0, 1);
                if(hs.contains(arr[i].toString())) {
                    flag = true;
                    break;
                }
                else hs.add(arr[i].toString());
            }

            if(flag) break;
            count++;
        }

        System.out.println(count);
    }
}