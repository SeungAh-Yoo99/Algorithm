import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();

        String extension;
        for (int i = 0; i < N; i++) {
            extension = br.readLine().split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for(String key : map.keySet()) {
            result.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.print(result);
    }
}