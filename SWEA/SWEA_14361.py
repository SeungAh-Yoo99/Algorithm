t = int(input())

for test_case in range(1, t + 1):
    # 문자열로 입력 받음
    s = input()
    # 자연수 n
    n = int(s)
    # n의 각 자리수를 배열에 넣는다
    arr = list(s)

    # arr의 조합으로 가능한 가장 큰 수
    maxMulN = int(''.join(sorted(arr, reverse=True)))

    result = ''
    i = 2
    # arr의 수 배열로 만들 수 있는 수보다 크면 반복문 탈출
    while (i * n <= maxMulN):
        # n의 배수를 구한 후 list로 바꿔준다.
        mul = list(str(i * n))
        testArr = arr.copy()

        # 두 배열이 같다면 result는 possible
        for m in mul:
            if m in testArr:
                # 두 배열에 같은 수가 있다면 testArr에서 지워준다.
                testArr.remove(m)
        # testArr가 비었다면 두 수 배열의 원소가 같은 것.
        if len(testArr) == 0:
            result = "possible"
            break

        i += 1

    # 반복문이 끝날 때까지 possible이 아니라면 impossible
    if result != "possible":
        result = "impossible"

    print("#{} {}".format(test_case, result))