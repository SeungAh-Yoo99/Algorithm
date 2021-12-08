#from collections import Counter

n = int(input())
card_list = list(map(int, input().split()))
m = int(input())
int_list = list(map(int, input().split()))

# # Counter 사용
# cnt_card = Counter(card_list)

# ans = []
# for num in int_list:
#     if num in cnt_card: # Counter 안에 num이 있으면
#         ans.append(cnt_card[num]) # 몇 갠지 답 출력 리스트에 넣어주고
#     else: # 없으면 0을 답 출력 리스트에 넣어줌.
#         ans.append(0)

# hash 사용
hash = {}
for _ in card_list:
    if _ in hash: # 이미 hash에 넣은 적 있는 수면
        hash[_] += 1 # +1
    else: # 처음 넣는 수면 1을 넣어줌
        hash[_] = 1

ans = []
for _ in int_list:
    if _ in hash: # hash에 있는 수면
        ans.append(hash[_]) # _에 대한 value를 답 출력 리스트에 넣어주고
    else: # 없으면 0을 답 출력 리스트에 넣어줌. 
        ans.append(0)

# 답 출력
for a in ans:
    print(a, end=' ')