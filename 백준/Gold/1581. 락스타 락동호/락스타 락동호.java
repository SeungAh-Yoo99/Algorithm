import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int FF = Integer.parseInt(st.nextToken());
        int FS = Integer.parseInt(st.nextToken());
        int SF = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());

        int result = 0;

        // FF가 있다면 먼저 음반에 모두 실는다.
        result += FF;
        // 느리게 시작하는 곡으로 넘어갈 수 있다면 넘어간다
        if(FS != 0) {
            // SS부터 모두 음반에 실는다.
            result += SS;
            // FS와 SF를 반복해서 음반에 실는다.
            if(FS > SF) {
                result += SF * 2 + 1;
            }
            else{
                result += FS * 2;
            }
        }
        // 빠르게 시작하는 곡이 하나도 없다면
        if(FF == 0 && FS == 0) {
            // SS부터 모두 음반에 실는다.
            result += SS;
            // SF가 있다면 하나 실는다.
            if(SF != 0) result += 1;
        }

        System.out.println(result);
    }
}