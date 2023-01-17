N, K = map(int, input().split())

sum1 = 1
for num in range(N, N - K, -1):
    sum1 *= num

sum2 = 1
for num in range(1, K + 1):
    sum2 *= num

print(sum1 // sum2)