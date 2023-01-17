T = int(input())
 
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
 
    #항상 더 긴 배열이 arr2, 짧은 배열이 arr1
    if N > M:
        arr2 = list(map(int, input().split()))
        arr1 = list(map(int, input().split()))
    else:
        arr1 = list(map(int, input().split()))
        arr2 = list(map(int, input().split()))
 
    #모든 경우의 수(|N - M| + 1)를 저장할 배열
    mulSum = [0] * (abs(N - M) + 1)
    for i in range(abs(N - M) + 1):
        for j in range(min(N, M)):
            mulSum[i] += arr1[j] * arr2[j + i]
    
    print("#{} {}".format(test_case, max(mulSum)))
