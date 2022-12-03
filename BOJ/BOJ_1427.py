n = list(input())

# 내림차순 정렬
n.sort(reverse=True)

# 출력
for i in range(len(n)):
    print(n[i], end='')