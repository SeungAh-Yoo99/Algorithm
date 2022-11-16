# 테스트 케이스의 수 t 입력
t = int(input())

for test_case in range(1, t + 1):
    # 행의 수 n, 열의 수 m 입력
    n, m = map(int, input().split())

	# 문자열 입력
    array = []
    for _ in range(n):
        array.append(list(input()))

    # array[i][j]일 때 i + j가 짝수일 때의 문자와 홀수일 때의 문자
    for i in range(n * m):
        if array[i // m][i % m] == '#':
            if ((i // m) + (i % m)) % 2 == 0:
                even = '#'
                odd = '.'
            else:
                even = '.'
                odd = '#'
            break
        elif array[i // m][i % m] == '.':
            if i % 2 == 0:
                even = '.'
                odd = '#'
            else:
                even = '#'
                odd = '.'
            break

    # array[i][j]일 때, i + j가 홀수일 때는 odd, 짝수일 때는 even과 문자열이 같아야 한다.
    result = ''
    for i in range(n * m):
        # 짝수일 때
        if ((i // m) + (i % m)) % 2 == 0:
            # odd와 문자열이 같다면 실패
            if array[i // m][i % m] == odd:
                result = "impossible"
                break
        # 홀수일 때
        else:
            # even과 문자열이 같다면 실패
            if array[i // m][i % m] == even:
                result = "impossible"
                break

    # 반복문이 끝날 때까지 result가  impossible이 아니라면 result는 possible
    if result != "impossible":
        result = "possible"

    print("#{} {}".format(test_case, result))