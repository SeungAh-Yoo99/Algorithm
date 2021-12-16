import sys

N = int(sys.stdin.readline())

coordinates = []
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    coordinates.append((y, x))

coordinates.sort()

for coordinate in coordinates:
    print(coordinate[1], coordinate[0])