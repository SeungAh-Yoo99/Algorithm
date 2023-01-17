t = int(input())

for test_case in range(1, t+1):
    arr = map(int, input().split())
    sum = 0

    for a in arr:
        if (a % 2 == 1):
            sum += a

    print("#"+str(test_case), sum)