import java.util.HashMap;
import java.util.TreeSet;

class UserSolution {

        static class Student implements Comparable<Student> {

            int mId;
            int mScore;

            Student() {}

            Student(int mId, int mScore) {
                this.mId = mId;
                this.mScore = mScore;
            }

            @Override
            public int compareTo(Student o) { // 점수 내림차순, id 내림차순으로 정렬

                return this.mScore == o.mScore ? o.mId - this.mId : o.mScore - this.mScore;
            }
        }

        static class StudentInfo {

            int grade;
            int gender;
            int score;

            StudentInfo(int grade, int gender, int score) {
                this.grade = grade;
                this.gender = gender;
                this.score = score;
            }
        }

        TreeSet<Student>[][] group;
        HashMap<Integer, StudentInfo> studentInfo;

        public void init() {

            group = new TreeSet[4][2];
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    group[i][j] = new TreeSet<>();
                }
            }

            studentInfo = new HashMap<>();
        }

        public int add(int mId, int mGrade, char mGender[], int mScore) {

            // 학생 정보를 해당 학년, 성별 그룹에 넣어준다.
            Student s = new Student(mId, mScore);
            group[mGrade][mGender[0] == 'm' ? 0 : 1].add(s);

            // 해당 학생의 학년, 성별 정보를 저장한다.
            StudentInfo si = new StudentInfo(mGrade, mGender[0] == 'm' ? 0 : 1, mScore);
            studentInfo.put(mId, si);

            // 해당 학년, 성별 그룹 중 가장 높은 성적을 가진 학생 중 가장 큰 id 값을 가진 학생 정보를 가져온다.
            Student ret = group[mGrade][mGender[0] == 'm' ? 0 : 1].first();

            // 해당 학생의 id 반환
            return ret.mId;
        }

        public int remove(int mId) {

            // mId 학생의 학년, 성별 정보를 가져온다
            StudentInfo si = studentInfo.get(mId);

            // 학생 정보가 없다면 0 반환
            if(si == null) {
                return 0;
            }

            // 해당 학생의 그룹에서 학생 기록을 지운다
            group[si.grade][si.gender].remove(new Student(mId, si.score));

            // 학생 정보도 지워준다
            studentInfo.remove(mId);

            // 학년, 성별이 동일한 학생이 없는 경우 0 반환
            if(group[si.grade][si.gender].isEmpty()) {
                return 0;
            }

            // 해당 학년, 성별 그룹 중 가장 낮은 성적을 가진 학생 중 가장 작은 id 값을 가진 학생 정보를 가져온다.
            Student ret = group[si.grade][si.gender].last();

            return ret.mId;
        }

        public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {

            Student ret = new Student(0, 300_001);

            Student compare = new Student(0, mScore);
            Student tmp;
            for (int i = 0; i < mGradeCnt; i++) {
                for (int j = 0; j < mGenderCnt; j++) {
                    tmp = group[mGrade[i]][mGender[j][0] == 'm' ? 0 : 1].lower(compare);
                    if(tmp != null && ret.compareTo(tmp) < 0) ret = tmp;
                }
            }

            return ret.mId;
        }
    }
