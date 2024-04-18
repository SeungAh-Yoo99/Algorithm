import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N <= 10) {
            System.out.println(N - 1);
            return;
        }
        else if(N > 1023) { // 1023번째 수가 9876543210으로 최대
            System.out.println(-1);
            return;
        }

        ArrayList<ArrayList<Long>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (long i = 0; i < 10; i++) {
            list.get(0).add(i);
        }


        long num;
        int size = 1; // (자릿수 - 1)
        int count = 10; // 현재 순서
        int mod = 1;
        long result = -1;
        w:while(size < 10) {

            list.add(new ArrayList<>());

            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < list.get(size - 1).size(); j++) {
                    if(i <= list.get(size - 1).get(j) / mod) break;

                    num = (long)i * mod * 10 + list.get(size - 1).get(j);
                    list.get(size).add(num);

                    count++;
                    if(count == N) {
                        result = num;
                        break w;
                    }
                }
            }

            size++;
            mod *= 10;
        }

        System.out.println(result);
    }
}