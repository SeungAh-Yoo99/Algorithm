import sys

N = int(sys.stdin.readline())

arr = [0] * 10001

for _ in range(N):
    arr[int(sys.stdin.readline())] += 1

for num in range(10001):
    if arr[num] != 0:
        for _ in range(arr[num]):
            print(num)