t = int(input())

n = []
for _ in range(t):
    n.append(int(input()))

# 가장 큰 n을 구해서, n만큼의 dp를 구한다.
max_n = max(n)

dp = []
# 0일 때의 수 추가
dp.append([1, 0])
# 1일 때의 수 추가
dp.append([0, 1])
# 2부터 max_n까지의 dp 구하기
for i in range(2, max_n + 1):
    dp.append([dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]])

# 출력
for i in n:
    print(dp[i][0], dp[i][1])