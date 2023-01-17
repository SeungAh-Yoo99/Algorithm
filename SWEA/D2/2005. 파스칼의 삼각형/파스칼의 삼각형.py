T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
    print("#{}".format(test_case))
    #삼각형 모양의 배열 생성
    pascal = [[0] * row for row in range(1, N + 1)]
 
    for i in range(N):
        #양 끝은 1 저장
        pascal[i][0] = 1
        pascal[i][-1] = 1
        #양 끝을 제외한 곳은 왼쪽 오른쪽 위의 합을 저장
        for j in range(1, i):
            pascal[i][j] = pascal[i - 1][j - 1] + pascal[i -1][j]
 
    #출력
    for i in range(N):
        for j in range(i + 1):
            print(pascal[i][j], end=" ")
        print()