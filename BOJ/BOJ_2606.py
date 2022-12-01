def dfs(graph, start, visited):
    visited[start] = True

    for i in graph[start]:
        if visited[i] == False:
            dfs(graph, i, visited)


cpt_num = int(input())

n = int(input())

visited = [False] * (cpt_num + 1)

graph = [[] for _ in range(cpt_num + 1)]
for _ in range(n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(graph, 1, visited)

count = 0
for i in visited:
    if i == True:
        count += 1

print(count - 1)