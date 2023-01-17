import copy
from collections import deque

# BFS
def virus():
    que = deque()
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # 2인 칸 큐에 넣어줌
    for i in range(n):
        for j in range(m):
            if virtual_room[i][j] == 2:
                que.append((i, j))

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (nx < 0) or (nx >= n) or (ny < 0) or (ny >= m):
                continue
            if virtual_room[nx][ny] == 0:
                virtual_room[nx][ny] = 2
                que.append((nx, ny))

    # 안전 영역 크기가 더 큰 것 저장
    global result
    count = 0
    for i in range(n):
        count += virtual_room[i].count(0)
    result = max(result, count)


n, m = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]

# 빈 칸의 인덱스를 구함
empty_room = []
for i in range(n):
    for j in range(m):
        if room[i][j] == 0:
            empty_room.append((i, j))

# 가능한 결과값
result = 0

for i in range(len(empty_room) - 2):
    for j in range(i + 1, len(empty_room) - 1):
        for k in range(j + 1, len(empty_room)):
             # 가상의 방을 만들어 벽을 세울 수 있는 모든 경우를 계산해봄
            virtual_room = copy.deepcopy(room)
            # 벽을 세움
            virtual_room[empty_room[i][0]][empty_room[i][1]] = 1
            virtual_room[empty_room[j][0]][empty_room[j][1]] = 1
            virtual_room[empty_room[k][0]][empty_room[k][1]] = 1
            # 바이러스를 퍼트림
            virus()


print(result)