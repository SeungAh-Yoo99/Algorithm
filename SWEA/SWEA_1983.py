T = int(input())
credit = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    #성적과 몇 번째 학생인지 저장
    grade = [[0, i + 1] for i in range(N)]

    for i in range(N):
        #중간, 기말, 과제 점수 입력받음
        midExam, finalExam, task = map(int, input().split())
        #평균 내서 grade에 저장
        grade[i][0] = (midExam * 0.35) + (finalExam * 0.45) + (task * 0.2)

    #내림차순으로 정렬
    grade = sorted(grade, reverse = True)

    #K번째 학생을 찾아서 학점을 출력
    for i in range(N):
        if grade[i][1] == K:
            print("#{} {}".format(test_case, credit[i//(N//10)]))