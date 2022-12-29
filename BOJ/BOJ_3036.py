from math import lcm

n = int(input())
arr = list(map(int, input().split()))

for i in range(1, n):
    lcm_num = lcm(arr[0], arr[i])
    print("{}/{}".format(lcm_num // arr[i], lcm_num // arr[0]))