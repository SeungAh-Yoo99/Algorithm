T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
 
    price = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    arr = [0, 0, 0, 0, 0, 0, 0, 0]
 
    for i in range(8):
        arr[i] = N // price[i]
        N %= price[i]
 
    print("#{}".format(test_case))
    print(*arr)