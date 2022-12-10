import heapq
INF = int(10e9)

def dijstra(start):
    arr[start] = 0
    q = []
    heapq.heappush(q, start)
    while(q):
        num = heapq.heappop(q)
        # 한 칸 뒤로 걷기
        if num - 1 >= 0 and arr[num - 1] > arr[num] + 1:
            arr[num - 1] = arr[num] + 1
            heapq.heappush(q, num - 1)
        # 한 칸 앞으로 걷기
        if num + 1 <= 100000 and arr[num + 1] > arr[num] + 1:
            arr[num + 1] = arr[num] + 1
            heapq.heappush(q, num + 1)
        # 순간이동
        if num * 2 <= 100000 and arr[num * 2] > arr[num]:
            arr[num * 2] = arr[num]
            heapq.heappush(q, num * 2)


n, k = map(int, input().split())

if n <= k:
    arr = [INF] * (100001)
    dijstra(n)
    dis = arr[k]
else:
    dis = n - k

print(dis)