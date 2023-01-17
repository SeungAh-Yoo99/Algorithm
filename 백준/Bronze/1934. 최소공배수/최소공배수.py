#유클리드 호제법
# 최대공약수 구하기
def GCD(x, y):
    while(y):
        x, y = y, x % y
    return x

# 최소공배수 구하기
def LCM(x, y):
    return x * y // GCD(x, y)

t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    print(LCM(a, b))