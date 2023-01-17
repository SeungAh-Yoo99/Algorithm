import heapq
INF = int(10e9)

def dijkstra(start):
    q = []
    distance[start] = 0
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


n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    # a는 출발 도시, b는 도착 도시, c는 버스 비용
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

s, e = map(int, input().split())

distance = [INF] * (n + 1)

dijkstra(s)

print(distance[e])