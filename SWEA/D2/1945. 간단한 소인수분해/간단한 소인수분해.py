T = int(input())
 
for test_case in range(1, T + 1):
    N = int(input())
    divisor = [2, 3, 5, 7, 11]
    abcde = [0, 0, 0, 0, 0]
    
    for i in range(5):
        while(N % divisor[i] == 0):
            abcde[i] += 1
            N //= divisor[i]
 
    print("#{}".format(test_case), end=" ")
    print(*abcde)