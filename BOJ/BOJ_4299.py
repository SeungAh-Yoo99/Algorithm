sum, sub = map(int, input().split())

# sum과 sub가 2로 나누어 떨어지지 않으면, 점수가 자연수가 아니게 된다.
# 문제에 sum이 항상 sub보다 크다는 조건이 없다.
if ((sum + sub) % 2 != 0) or (sum - sub < 0):
    print(-1)
    
else:
    a = (sum + sub) // 2
    b = sum - a
    print(max(a, b), min(a, b))