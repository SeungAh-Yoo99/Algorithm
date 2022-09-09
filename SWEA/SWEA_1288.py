T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    num = [0] * 10
    k = 1

    while(0 in num):
        str_N = str(N * k)
        for s in str_N:
            num[int(s)] += 1
        k += 1

    print("#{} {}".format(test_case, (k - 1) * N))