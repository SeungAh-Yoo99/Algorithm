# 4개의 수를 공백을 기준으로 끊어 한 줄로 입력 받는다.
x, y, w, h = map(int, input().split())

up = h - y # 위쪽 방향 거리
down = y # 아래쪽 방향 거리
right = w - x # 오른쪽 방향 거리
left = x # 왼쪽 방향 거리

mini = min(up, down, right, left) # 4가지 경우 중 최소값
print(mini)