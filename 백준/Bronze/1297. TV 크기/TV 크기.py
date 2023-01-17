import sys
import math

D, H, W = map(int, sys.stdin.readline().split())

X = math.sqrt((D ** 2) / (H ** 2 + W ** 2))

h = math.trunc(H * X)
w = math.trunc(W * X)

print(h, w)