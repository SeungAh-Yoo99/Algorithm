import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Word {

        String word; // 단어
        int count; // 등장 횟수
        int length; // 단어 길이

        Word(String word) {
            this.word = word;
            count = 0;
            length = word.length();
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Word> words = new HashMap<>();
        String w;
        Word word;
        for (int i = 0; i < N; i++) {
            w = br.readLine();

            if(w.length() >= M) { // 단어의 길이가 M 이상일 때만

                word = words.get(w);

                if(word == null) { // 처음 입력받은 단어라면
                    word = new Word(w);
                    words.put(w, word);
                }

                // 해당 단어 등장 횟수 저장
                word.count++;
            }
        }

        // 정렬을 위해 단어들을 리스트에 담기
        List<Word> list = new ArrayList<>();
        for(String k : words.keySet()) {
            list.add(words.get(k));
        }

        // 정렬
        Collections.sort(list, (o1, o2) -> {
            if(o1.count != o2.count) {
                return o2.count - o1.count;
            }

            if(o1.length != o2.length) {
                return o2.length - o1.length;
            }

            return o1.word.compareTo(o2.word);
        });

        // 출력
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).word).append("\n");
        }
        System.out.print(result);
    }
}