T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
    #NxN의 1차 배열 생성
    arr = [0] * N * N
    num = 0
 
    #처음 N개는 처음부터 순서대로 배열에 넣어준다.
    for i in range(N):
        num  += 1
        arr[i] = num
 
    idx = N - 1
    for i in range(N - 1, 0, -2):
        for j in range(i):
            idx += N
            num += 1
            arr[idx] += num
        for j in range(i):
            idx -= 1
            num += 1
            arr[idx] += num
        for j in range(i - 1):
            idx -= N
            num += 1
            arr[idx] += num
        for j in range(i - 1):
            idx += 1
            num += 1
            arr[idx] += num
 
    print("#{}".format(test_case))
    for i in range(0, N*N, N):
        for j in range(N):
            print(arr[i + j], end=" ")
        print()