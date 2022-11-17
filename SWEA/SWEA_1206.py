for test_case in range(1, 11):
    # 건물의 개수 n
    n = int(input())

    result = 0
    arr = list(map(int, input().split()))
    for i in range(2, n -2):
        sub = arr[i] - max(arr[i - 2], arr[i - 1], arr[i + 1], arr[i + 2])
        if sub > 0:
            result += sub

    print("#{} {}".format(test_case, result))