for test_case in range(1, 11):
    # 덤프의 횟수 n
    n = int(input())
 
    # 상자의 높이값
    height = list(map(int, input().split()))
 
    # 덤프의 횟수만큼 반복
    for i in range(n):
        # 높이값 정렬
        height.sort()
 
        height[0] += 1
        height[99] -= 1
 
    height.sort()
    result = height[99] - height[0]
    print("#{} {}".format(test_case, result))
