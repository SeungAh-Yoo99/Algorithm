import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person> {

        List<Integer> list;
        int size;

        Person() {
            list = new ArrayList<>();
            size = 0;
        }

        void add(int w) {
            list.add(w);
            size++;
        }

        @Override
        public int compareTo(Person p) {
            return this.size - p.size;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 직원 리스트
        List<Person> people = new ArrayList<>();
        people.add(new Person());

        // 각 작업별로 수행할 수 있는 직원 리스트
        List<List<Integer>> works = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            works.add(new ArrayList<>());
        }

        int num, w;
        for (int i = 1; i <= N; i++) {
            people.add(new Person());
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                w = Integer.parseInt(st.nextToken());
                people.get(i).add(w);
                works.get(w).add(i);
            }
        }

        List<Person> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(people.get(i));
        }

        // 수행한 작업 체크
        boolean[] isWorked = new boolean[M + 1];

        int answer = 0;

        Person p;
        while(!list.isEmpty()) {

            // 정렬
            Collections.sort(list);

            p = list.get(0);
            list.remove(0);

            // 현재 직원이 수행할 수 있는 작업이 남아있지 않다면 넘김
            if(p.size == 0) continue;

            for(int work : p.list) {
                // 이미 수행한 작업이면 넘김
                if(isWorked[work]) continue;

                isWorked[work] = true;
                answer++;

                for(int idx : works.get(work)) {
                    people.get(idx).size--;
                }

                break;
            }
        }

        System.out.println(answer);
    }
}