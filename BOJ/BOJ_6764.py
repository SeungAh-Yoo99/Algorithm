# 총 4개의 수를 받고
# 수들의 순서가 증가수열이면, "Fish Rising" 출력
# 감소수열이면 "Fish Diving" 출력
# 모든 수들이 다 같은 값이면 "Fish At Constant Depth" 출력
# 다 아니면 "No Fish" 출력

import sys

depth = [int(sys.stdin.readline()) for _ in range(4)]

if depth[0] < depth[1] and depth[1] < depth[2] and depth[2] < depth[3]:
    print("Fish Rising")

elif depth[0] > depth[1] and depth[1] > depth[2] and depth[2] > depth[3]:
    print("Fish Diving")

elif max(depth) == min(depth):
    print("Fish At Constant Depth")

else:
    print("No Fish")