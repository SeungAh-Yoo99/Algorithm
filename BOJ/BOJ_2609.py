# 최대공약수 구하는 함수
def gcd(x, y):
    while(True):
        if x % y == 0:
            return y
        else:
            t = x % y
            x = y
            y = t
            
# 최소공배수 구하는 함수
def lcm(x, y):
    return x * y // gcd(x, y)

n, m = map(int, input().split())

if n > m:
    print(gcd(n, m))
    print(lcm(n, m))
else:
    print(gcd(m, n))
    print(lcm(m, n))

# import math

# n, m = map(int, input().split())

# print(math.gcd(n, m))
# # Python 3.9 부터 사용 가능
# # print(math.lcm(n, m))
# print(n * m // math.gcd(n, m))