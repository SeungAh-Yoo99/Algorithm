def isPrime(n):
    if n<2:
        return False
    elif n ==2:
        return True
    else:
        for i in range(2, int(n/2)+2):
            if (n%i == 0):
                return False
        return True

n = int(input())
num = []
ans = []
for i in range(0, n):
    num.append(int(input()))
    ans.append(0)

for i in range(0, n):
    half = int(num[i] / 2)
    for j in range(half, 0, -1):
        if isPrime(j):
            if isPrime(num[i] - j):
                ans[i]=j
                break

for i in range(0, n):
    print(ans[i], num[i]-ans[i])