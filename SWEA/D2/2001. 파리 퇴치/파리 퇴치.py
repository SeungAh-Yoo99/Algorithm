T = int(input())
 
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
 
    # NxN 배열 입력
    arr = [list(map(int, input().split())) for _ in range(N)]
 
    max_num = 0 #최대값 저장
    #가능한 모든 MxM 영역의 수를 구한다.
    for i in range(N - M + 1):
        for j in range(N - M + 1):
            num = 0
            for x in range(M):
                for y in range(M):
                    num += arr[i + x][j + y]
            #그 중에서 가장 큰 수 저장
            if num > max_num:
                max_num = num
 
    #출력
    print("#{} {}".format(test_case, max_num))