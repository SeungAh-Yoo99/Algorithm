N = int(input())

six_in_n = 666
# 지금 six_in_n의 번호
cnt = 0

while(True):
    # six_in_n에 '666'이 포함되어 있으면, count를 올려주고
    if '666' in str(six_in_n):
        cnt += 1
        # count가 N과 같으면 지금 six_in_n이 답
        if cnt == N:
            print(six_in_n)
            break
    
    six_in_n += 1