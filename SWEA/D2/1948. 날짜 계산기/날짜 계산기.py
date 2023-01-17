T = int(input())
date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
 
for test_case in range(1, T + 1):
    m1, d1, m2, d2 = map(int, input().split())
    #시작 날짜도 포함하므로 1로 시작
    day = 1
 
    #두 날짜가 같은 달일 경우
    if (m1 == m2):
        day += d2 - d1
    #다른 달일 경우
    else:
        #두 날짜의 사이 달의 날짜 수를 더해주고
        for i in range(m1 + 1, m2):
            day += date[i]
        #시작하는 달, 끝나는 달에서도 포함된 날짜를 더해준다
        day += date[m1] - d1 + d2
 
    print("#{} {}".format(test_case, day))