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


"""
num이 주어졌을 때, half = num/2이 소수라면 답은 half이다.
하지만 half이 소수가 아니라면 half=half-1 한다.
half가 소수가 될 때까지 위의 과정을 반복한다.
half가 소수가 됐을 때, num-half도 소수라면 답은 half
소수가 아니라면 위의 과정을 다시 반복한다.
이렇게 half와 num-half가 둘 다 소수일 때까지 반복한다.
"""