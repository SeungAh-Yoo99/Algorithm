n = input()

# 정답을 담을 list
ans = []

# n이 0이면 반복문 중지
while(n != '0'):
    # n을 반으로 나눠 따로 저장해준다.
    if len(n) % 2 == 0:
        front_n = n[ : len(n) // 2]
        latter_n = n[len(n) // 2 : ]
    else:
        front_n = n[ : len(n) // 2]
        latter_n = n[len(n) // 2 + 1: ]
        
    # 뒷부부을 저장한 문자열의 순서를 뒤집어준다.
    reversed_latter_n = "".join(reversed(latter_n))
    
    # 가운데를 기준으로 앞 부분과 뒷 부분을 뒤집은 문자열이 같은지 확인
    if front_n == reversed_latter_n:
        ans.append('yes')
    else:
        ans.append('no')
    
    # 다음 문자열 입력
    n = input()
    
# 정답 출력
for answer in ans:
    print(answer)