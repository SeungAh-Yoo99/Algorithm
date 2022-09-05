T = int(input())

for test_case in range(1, T + 1):
    N = int(input())

    sumNsub = 0
    for i in range(1, N + 1):
        #짝수일 경우
        if i % 2 == 0:
            sumNsub -= i
        #홀수일 경우
        else:
            sumNsub += i

    print("#{} {}".format(test_case, sumNsub))