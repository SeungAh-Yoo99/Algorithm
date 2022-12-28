n = int(input())
arr = list(map(int, input().split()))

# N은 입력 받은 약수들 중, 가장 작은 수와 가장 큰 수의 곱이다.
ans = min(arr) * max(arr)
print(ans)