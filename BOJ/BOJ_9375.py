t = int(input())

for _ in range(t):
    n = int(input())
    dic = {}
    for i in range(n):
        clothe, kind = map(str, input().split())
        if dic.get(kind):
            dic[kind] += 1
        else:
            dic[kind] = 1

    ans = 1
    for v in dic.values():
        ans *= v + 1
    print(ans - 1)