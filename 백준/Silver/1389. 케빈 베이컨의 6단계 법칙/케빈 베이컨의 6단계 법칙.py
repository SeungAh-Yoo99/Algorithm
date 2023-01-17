INF = int(10e9)

n, m = map(int, input().split())

arr = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    arr[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    arr[a][b] = 1
    arr[b][a] = 1

for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            arr[a][b] = min(arr[a][b], arr[a][k] + arr[k][b])

kabin = 1
for i in range(2, n + 1):
    if sum(arr[kabin]) > sum(arr[i]):
        kabin = i

print(kabin)