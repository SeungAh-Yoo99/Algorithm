N, M = map(int, input().split())

A = [list(map(int, input().split())) for _ in range(N)]
B = [list(map(int, input().split())) for _ in range(N)]

for n in range(N):
    for m in range(M):
        A[n][m] += B[n][m]
    print(*A[n])