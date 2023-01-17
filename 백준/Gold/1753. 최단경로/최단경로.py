import heapq
INF = int(10e9)

def dijstra(start):
    q = []
    distance[k] = 0
    heapq.heappush(q, (0, start))
    while q:
        dis, now = heapq.heappop(q)
        if distance[now] < dis:
            continue
        for i in graph[now]:
            cost = dis + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

# 정점의 개수 v, 간선의 개수 e
v, e = map(int, input().split())
# 시작 정점의 번호 k
k = int(input())
# 간선 정보
graph = [[] for _ in range(v + 1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

distance = [INF] * (v + 1)

dijstra(k)

for i in range(1, v + 1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])