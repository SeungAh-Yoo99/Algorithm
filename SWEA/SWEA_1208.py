# for test_case in range(1, 11):
#     # 덤프의 횟수 n
#     n = int(input())

#     # 상자의 높이값 입력
#     height = list(map(int, input().split()))

#     # 덤프의 횟수만큼 반복
#     for i in range(n):
#         # 상자 높이값의 최소, 최대 인덱스 구하기
#         min_height = height[0]
#         max_height = height[0]
#         min_index = 0
#         max_index = 0
#         for j in range(100):
#             if height[j] < min_height:
#                 min_height = height[j]
#                 min_index = j
#             if height[j] > max_height:
#                 max_height = height[j]
#                 max_index = j

#         # 상자 높이값의 최대는 -1, 최소는 +1을 하여 덤프 진행
#         height[min_index] += 1
#         height[max_index] -= 1

#     result = max(height) - min(height)
#     print("#{} {}".format(test_case, result))

# 정렬
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