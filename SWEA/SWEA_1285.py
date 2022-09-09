T = int(input())

for test_case in range(1, T + 1):
    N = int(input())

    mm = list(map(int, input().split()))

    #0에서 가까운 거리를 찾아야 하므로 절대값으로 바꿔준다.
    for i in range(len(mm)):
        mm[i] = abs(mm[i])

    #min 함수로 최소값 출력, count 함수로 최소값의 개수 출력
    print("#{} {} {}".format(test_case, min(mm), mm.count(min(mm))))