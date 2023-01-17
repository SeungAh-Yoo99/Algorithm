import sys

n = int(input())
num = [int(sys.stdin.readline()) for _ in range(n)]
sorted_num = sorted(num)

for i in sorted_num:
    print(i)