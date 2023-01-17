INF = int(10e9)

n = int(input())
m = int(input())

arr = [[INF] * (n + 1) for _ in range(n  + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    arr[a][b] = min(arr[a][b], c)

for i in range(1, n + 1):
    arr[i][i] = 0

for i in range(1, n + 1):
    for j in range(1, n + 1):
        for k in range(1, n + 1):
            arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if arr[i][j] == INF or i == j:
            print(0, end=' ')
        else:
            print(arr[i][j], end=' ')
    print()