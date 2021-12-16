# 11일 11시 11분 부터
# D일 H시 M분 까지 몇 분이 흘렀는지 출력하라.

import sys

D, H, M = map(int, sys.stdin.readline().split())

# starting time
st = 11 * 60 + 11
# ending time
et = ((D - 11) * 24 * 60) + H * 60 + M

total = et - st
if total >= 0:
    print(total)
else:  # ending time이 starting time보다 빠르면 -1 출력
    print(-1)