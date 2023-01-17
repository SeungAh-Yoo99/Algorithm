n = int(input())
card_list = list(map(int, input().split()))
m = int(input())
int_list = list(map(int, input().split()))

hash = {}
for _ in card_list:
    if _ in hash:
        hash[_] += 1
    else:
        hash[_] = 1

ans = []
for _ in int_list:
    if _ in hash:
        ans.append(hash[_])
    else:
        ans.append(0)

# 답 출력
for a in ans:
    print(a, end=' ')