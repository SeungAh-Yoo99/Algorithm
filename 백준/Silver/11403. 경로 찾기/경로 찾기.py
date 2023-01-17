# 정점의 개수 n
n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

# 플로이드 워셜 알고리즘
for i in range(n):
    for j in range(n):
        for k in range(n):
            # j에서 k까지 바로 가는 길이 없는데
            if graph[j][k] == 0:
                # i를 거쳐 j->i->k로 가는 길이 있다면
                if graph[j][i] == 1 and graph[i][k] == 1:
                    # j에서 k까지 갈 수 있다고 판단
                    graph[j][k] = 1

for i in range(n):
    print(*graph[i])