n = input()

# 정답을 담을 list
ans = []

while n != '0':
    if n[::-1] == n:
        ans.append('yes')
    else:
        ans.append('no')
       
    # 다음 문자열 입력
    n = input()
    
# 정답 출력
for answer in ans:
    print(answer)