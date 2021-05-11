import math

t = int(input())
ans = []

for i in range(0, t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    # 조규현과 백승환의 거리
    r = math.sqrt(((x1 - x2) ** 2) + ((y1 - y2) ** 2))

    R = [r1, r2, r]
    m = max(R)
    R.remove(m)

    # 각 점을 원의 중심이라고 가정
    if ((r == 0) & (r1 == r2)): # 두 원이 일치
        ans.append(-1)
    elif (m == sum(R)): # 두 원이 외접이나 내접할 경우
        ans.append(1)
    elif (m > sum(R)): # 두 원이 만나지 않는 경우
        ans.append(0)
    else: # 두 원이 두 점에서 만날 경우
        ans.append(2)


for i in range(0, t):
    print(ans[i])