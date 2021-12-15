N = int(input())

coordinates = []
for _ in range(N):
    x, y = map(int, input().split())
    coordinates.append([x, y])

coordinates.sort()

for c in coordinates:
    print(c[0], c[1])