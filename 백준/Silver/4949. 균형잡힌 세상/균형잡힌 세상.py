import sys

str = sys.stdin.readline()

while (str != '.\n'):
    stack = []
    for i in range(len(str) - 1):
        if str[i] == '(' or str [i] == '[':
            stack.append(str[i])
        elif str[i] == ')':
            if len(stack) == 0:
                stack.append(' ')
                break
            elif stack[-1] == '(':
                stack.pop()
            else:
                break
        elif str[i] == ']':
            if len(stack) == 0:
                stack.append(' ')
                break
            elif stack[-1] == '[':
                stack.pop()
            else:
                break
            
    if len(stack) == 0:
        print('yes')
    else:
        print('no')
        
    str = sys.stdin.readline()