# 테스트 케이스의 수 t
t = int(input())
 
for test_case in range(1, t + 1):
    n = int(input())
    a = list(map(int, input().split()))
 
    max_mul = -1
    for i in range(n - 1):
        for j in range(i + 1, n):
            mul = a[i] * a[j]
            num = list(str(mul))
            result = True
            for k in range(len(num) - 1):
                if num[k] > num[k + 1]:
                    result = False
                    break
            
            if result == True:
                max_mul = max(max_mul, mul)
 
    print("#{} {}".format(test_case, max_mul))
