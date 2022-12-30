n, k = map(int, input().split())

# 이항 계수 구하기
num = 1
for i in range(2, n + 1):
    num *= i

for i in range(2, k + 1):
    num //= i

for i in range(2, n - k + 1):
    num //= i

ans = num % 10007
print(ans)