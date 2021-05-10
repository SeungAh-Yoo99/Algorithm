ans = []

while True:
    # 세 변의 길이 입력
    tri = list(map(int, input().split()))

    # '0 0 0'이 입력되면 반복문 종료
    if ((tri[0] == 0) & (tri[1] == 0) & (tri[2] == 0)):
        break

    maximum = max(tri)
    tri.remove(maximum)

    # 직각삼각형의 조건을 성립하는지 검사
    if ((maximum ** 2) == (tri[0] ** 2) + (tri[1] ** 2)):
        ans.append('right')
    else:
        ans.append('wrong')

for i in range(0, len(ans)):
    print(ans[i])

"""
직각 삼각형은
가장 긴 변의 제곱 = 나머지 두 변의 제곱의 합
을 성립해야 한다.
"""