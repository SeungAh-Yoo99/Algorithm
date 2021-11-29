import sys
from collections import Counter

n = int(input())
num_list = [int(sys.stdin.readline()) for _ in range(n)]

# 산술평균
sum = 0
for num in num_list:
    sum += num
avg = round(sum / n) # 소수점 이하 첫째 자리 반올림

# 중앙값
mid_idx = n // 2
sorted_num_list = sorted(num_list)
mid = sorted_num_list[mid_idx]

# 최빈값
cnt = Counter(sorted_num_list).most_common() # 데이터 개수가 많은 순으로 정렬
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]: # 최빈값 2개 이상
    max_cnt_num = cnt[1][0]
else: # 최빈값 1개
    max_cnt_num = cnt[0][0]
# cnt_list = [0 for _ in range(n)]

# for i in range(1, n): # 정렬된 list에 i-1번째 num과 i번째 num이 같다면
#     if sorted_num_list[i - 1] == sorted_num_list[i]:
#         cnt_list[i] = cnt_list[i-1] + 1 # count를 올려줌
# max_cnt = max(cnt_list) # 가장 많은 횟수의 count를 구해줌.

# max_cnt_list = []
# for i in range(n): # 최빈값에 해당하는 num들을 구해준다.
#     if cnt_list[i] == max_cnt:
#         max_cnt_list.append(sorted_num_list[i])

# if n == 1: # 입력이 한 개만 들어왔다면
#     max_cnt_num = num_list[0]
# elif len(max_cnt_list) == 1: # 최빈값에 해당하는 num이 한개면
#     max_cnt_num = max_cnt_list[0]
# else: # 2개 이상이면 두 번째 것 저장
#     max_cnt_num = max_cnt_list[1]

# 범위
rng = max(num_list) - min(num_list)

# 출력
print(avg) # 산술평균
print(mid) # 중앙값
print(max_cnt_num) # 최빈값
print(rng) # 범위