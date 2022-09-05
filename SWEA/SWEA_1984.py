T = int(input())

for test_case in range(1, T + 1):
    numList = list(map(int, input().split()))

    max_num = max(numList)
    min_num = min(numList)

    avg = 0
    for i in range(10):
        #최대값과 최소값이 아닐 경우에만 더해줌
        if numList[i] != max_num and numList[i] != min_num:
            avg += numList[i]
    avg = round(avg / 8)

    # #sorted 함수 사용
    # avg = round(sum(sorted(numList)[1:9]) / 8)

    print("#{} {}".format(test_case, avg))