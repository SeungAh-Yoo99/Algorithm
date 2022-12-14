INF = int(10e9)

n, m = map(int, input().split())

arr = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    arr[i][i] = 0

# 친구 관계일 경우 1 입력
for _ in range(m):
    a, b = map(int, input().split())
    arr[a][b] = 1
    arr[b][a] = 1

# 플로이드-워셜 알고리즘
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            arr[a][b] = min(arr[a][b], arr[a][k] + arr[k][b])

# 케빈 베이컨의 수가 가장 작은 사람 구하기
kabin = 1
for i in range(2, n + 1):
    if sum(arr[kabin]) > sum(arr[i]):
        kabin = i

print(kabin)