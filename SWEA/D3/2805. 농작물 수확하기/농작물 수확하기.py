# 테스트 케이스의 개수 t
t = int(input())
 
for test_case in range(1, t + 1):
    # 농장의 크기 n
    n = int(input())
 
    # 농장의 정보
    arr = []
    for i in range(n):
        s = list(input())
        for i in range(n):
            s[i] = int(s[i])
        arr.append(s)
 
    # 수익을 담을 result
    result = 0
 
    # 수익 계산
    mid = n // 2
    for i in range(mid):
        # 위에서부터 내려가며 포함하는 인덱스 증가(마름모꼴로 검사)
        result += sum(arr[i][mid - i:mid + i + 1:])
        # 밑에서부터 올라가며 포함하는 인덱스 증가(마름모꼴로 검사)
        result += sum(arr[n - i - 1][mid - i:mid + i + 1:])
    # 가운데 검사
    result += sum(arr[mid])
 
    print("#{} {}".format(test_case, result))