import sys

n = int(input())
num_list = [int(sys.stdin.readline()) for _ in range(n)]

stack = [] # 스택
result = [] # 결과값 저장
result_no = True # 불가능한 경우 False
cnt = 0

for num in num_list:
    
    while cnt < num:
        cnt += 1
        stack.append(cnt)
        result.append('+')
        
    # 스택의 가장 위의 수와 num과 같으면 pop하고 result에 '-' 저장
    if stack[-1] == num:
        stack.pop()
        result.append('-')
    # 스택의 가장 위의 수가 num과 다르다면 스택 불가능
    else:
        result_no = False
        break
    
if result_no == False:
    print('NO')
else:
    print('\n'.join(result))