T = int(input());
 
for test_case in range(1, T + 1):
    N = int(input())
    arr = sorted(list(map(int, input().split())))
 
    print("#{}".format(test_case), end=" ")
    print(*arr)