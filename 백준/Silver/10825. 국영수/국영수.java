import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Student implements Comparable{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Object o) {

            Student s = (Student) o;

            if(this.kor != s.kor) { // 국어 점수가 감소하는 순서로
                return s.kor - this.kor;
            } else { // 국어 점수가 같으면
                if(this.eng != s.eng) { // 영어 점수가 증가하는 순서로
                    return this.eng - s.eng;
                }else { // 국어, 영어 점수가 같으면
                    if(this.math != s.math) { // 수학 점수가 감소하는 순서로
                        return s.math - this.math;
                    } else { // 모든 점수가 같으면 이름 사전 순
                        return this.name.compareTo(s.name);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        String name; int kor, eng, math;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            kor = Integer.parseInt(st.nextToken());
            eng = Integer.parseInt(st.nextToken());
            math = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(students[i].name).append("\n");
        }
        System.out.println(result);
    }
}