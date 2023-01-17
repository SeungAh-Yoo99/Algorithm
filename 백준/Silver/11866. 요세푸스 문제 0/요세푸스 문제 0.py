import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

arr = [i + 1 for i in range(N)]
arr = deque(arr)

print('<', end='')

while(arr):
    for _ in range(K - 1):
        arr.append(arr.popleft())
    print(arr.popleft(), end='')

    if arr:
        print(', ', end='')

print('>')