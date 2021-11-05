n = int(input())
a = list(map(int, input().split()))
b, c = map(int, input().split())

num = 0 # 감독관의 최소 수
for i in range(n):
    a[i] -= b # b는 무조건 1명이 들어가야 하므로 일단 b가 맡는 학생 수만큼은 빼고 시작
    num += 1  # 감독관 수도 일단 한명 더하고 시작.

    if a[i] > 0: # b가 모든 학생을 이미 맡았을 수도 있으므로 이 조건문을 달아줌.
        num += a[i]//c # 남은 학생수를 c로 나눈 몫을 더해줌.

        if a[i]%c != 0: # 위에 식에서 나머지가 있다면, 그 학생을 담당하는 감독관이 한 명 더 필요하므로 +1 해줌.
            num += 1

print(num)