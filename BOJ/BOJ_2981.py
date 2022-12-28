from math import gcd, sqrt

# 입력
n = int(input())
arr1 = []
for _ in range(n):
    arr1.append(int(input()))
arr1.sort()

# 입력 받은 수들(arr1) 간 차이 구하기
arr2 = []
for i in range(1, n):
    arr2.append(arr1[i] - arr1[i - 1])

# 입력 받은 수들의 차(arr2) 간 최대공약수 구하기
divi = arr2[0]
for i in range(1, len(arr2)):
    divi = gcd(divi, arr2[i])

# 최대공약수의 약수들 구하기(1 제외)
result = set()
for i in range(2, int(sqrt(divi)) + 1):
    if divi % i == 0:
        result.add(i)
        result.add(divi // i)
result.add(divi)

# 정렬
result = sorted(list(result))

# 출력
print(*result)