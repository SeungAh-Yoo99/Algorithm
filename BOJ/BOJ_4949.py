import sys

str = sys.stdin.readline()

while (str != '.\n'):
    stack = [] # 괄호가 들어오면 스택에 저장
    
    for i in range(len(str) - 1):
        # 왼쪽 괄호는 스택에 무조건 추가
        if str[i] == '(' or str [i] == '[':
            stack.append(str[i])
            
        # 오른쪽 소괄호가 들어왔는데
        elif str[i] == ')':
            # stack의 길이가 0일 경우 (짝이 되는 오른쪽 괄호가 먼저 들어오지 않음)
            if len(stack) == 0:
                stack.append(' ') # 마지막 답 출력 시 len이 0이 되어 yes가 출력되는 것을 방지
                break
            
            # 이전에 스택에 들어온 괄호가 왼쪽 소괄호면 짝을 이룰 수 있음
            elif stack[-1] == '(':
                stack.pop() # 짝을 이룬 괄호는 스택에서 pop해준다.
                
            # 이전에 스택에 들어온 것이 왼쪽 소괄호가 아니면 break 해줌.
            # (스택에 남아있는 것들이 있으므로 len은 0이 아니고 no가 출력됨.)
            else:
                break
            
        # 오른쪽 소괄호가 들어왔을 경우와 동일
        elif str[i] == ']':
            if len(stack) == 0:
                stack.append(' ')
                break
            elif stack[-1] == '[':
                stack.pop()
            else:
                break
            
    # 문자열이 균형을 이뤘다면 for문을 정상적으로 마치고 len은 0이 된다.
    if len(stack) == 0:
        print('yes')
    else:
        print('no')
        
    str = sys.stdin.readline()