def dfs(v, count):
    global max_count
    # 방문 처리
    visited[v] = True
    # v에 연결되어 있는 점들 중
    for i in graph[v]:
        # 아직 방문하지 않았다면
        if visited[i] == False:
            # 방문한다
            dfs(i, count + 1)
    # 더 이상 방문할 수 있는 점이 없다면
    # 방문처리를 취소해줌. (다른 경로에서 지나갈 수도 있기 때문에)
    visited[v] = False
 
    # 이때 max_count보다 현재의 경로의 길이가 더 크다면
    if count > max_count:
        # max_count 갱신
        max_count = count
 
# 테스트 케이스의 수 t
t = int(input())
 
for test_case in range(1, t + 1):
    n, m = map(int, input().split())
    # 경로를 넣을 배열
    graph = [[] for _ in range(n + 1)]
    # 방문 처리 배열
    visited = [False] * (n + 1)
 
    # 간선 정보 입력
    for i in range(m):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
 
    # 최장 간선의 길이 구하기
    count, max_count = 0, 0
 
    for i in range(1, n + 1):
        dfs(i, 1)
 
    print("#{} {}".format(test_case, max_count))