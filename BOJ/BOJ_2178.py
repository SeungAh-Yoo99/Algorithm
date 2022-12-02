from collections import deque

n, m = map(int, input().split())

arr = []
for i in range(n):
    arr.append(list(input()))

# 카운트 배열
cnt = [[0]* m for _ in range(n)]

# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

q = deque()
q.append((0, 0))
# 방문처리
arr[0][0] = '0'
cnt[0][0] = 1

while(q):
    x, y = q.popleft()

    # 동, 서, 남, 북으로 갈 수 있는 곳 체크
    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]
        # 배열의 인덱스 범위 체크
        if (xx >= 0) and (xx < n) and (yy >= 0) and (yy < m):
            if arr[xx][yy] == '1':
                q.append((xx, yy))
                arr[xx][yy] = '0'
                cnt[xx][yy] = cnt[x][y] + 1

print(cnt[n - 1][m - 1])