import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = new String[5];
        for (int i = 0; i < 5; i++) {
            strArr[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(i < strArr[j].length()) result.append(strArr[j].charAt(i));
            }
        }
        System.out.println(result);
    }
}