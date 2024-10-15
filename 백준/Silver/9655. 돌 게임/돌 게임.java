import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // N이 홀수면 상근이가 이김
        if(N % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}