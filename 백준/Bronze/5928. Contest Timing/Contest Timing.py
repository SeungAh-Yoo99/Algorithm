import sys

D, H, M = map(int, sys.stdin.readline().split())

ct = 11 * 60 + 11

st = ((D - 11) * 24 * 60) + H * 60 + M

total = st - ct
if total >= 0:
    print(total)
else:
    print(-1)