# 출발점을 포함하는 행성계와 도착점을 포함하는 행성계의 합을 구하면 된다.
t = int(input()) # 테스트 케이스 개수 입력
for _ in range(t):
    # 출발점, 도착점 입력
    x1, y1, x2, y2 = map(int, input().split())

    # 행성계 정보 입력
    point = []
    n = int(input())
    for i in range(n):
        cx, cy, r = map(int, input().split())
        point.append((cx, cy, r))

    count = 0
    for i in range(n):
        # 출발점과 각 원의 중점의 거리가 해당 원의 반지름 보다 짧으면, 행성계 안에 출발점이 포함되어 있음.
        dis1 = (x1 - point[i][0]) ** 2 + (y1 - point[i][1]) ** 2
        if dis1 < (point[i][2] ** 2):
            count += 1
        # 도착점과 각 원의 중점의 거리가 해당 원의 반지름 보다 짧으면, 행성계 안에 도착점이 포함되어 있음.
        dis2 = (x2 - point[i][0]) ** 2 + (y2 - point[i][1]) ** 2
        if dis2 < (point[i][2] ** 2):
            count += 1
        # 만약 하나의 원 안에 출발점과 도착점이 모두 포함되어 있다면, 해당 행성계는 지입/이탈할 필요가 없다.
        if dis1 < (point[i][2] ** 2) and dis2 < (point[i][2] ** 2):
            count -= 2

    print(count)