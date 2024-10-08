import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int[] arr = new int[3];
        while(true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1]) {
                result.append("Invalid\n");
            }else if(arr[0] == arr[1] && arr[1] == arr[2]) {
                result.append("Equilateral\n");
            }else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                result.append("Isosceles \n");
            }else {
                result.append("Scalene\n");
            }
        }

        System.out.print(result);
    }
}