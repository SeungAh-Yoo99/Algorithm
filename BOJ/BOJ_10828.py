n = int(input())

stack = []
ans = []
count = 0
for i in range(0, n):
    s = input().split()
    if s[0] == 'push':
        stack.append(s[1])
    elif s[0] == 'pop':
        if len(stack) == 0:
            ans.append(-1)
        else:
            ans.append(stack[len(stack)-1])
            del stack[len(stack)-1]
    elif s[0] == 'size':
        ans.append(len(stack))
    elif s[0] == 'empty':
        if len(stack) == 0:
            ans.append(1)
        else:
            ans.append(0)
    elif s[0] == 'top':
        if len(stack) == 0:
            ans.append(-1)
        else:
            ans.append(stack[len(stack)-1])

for i in range(0, len(ans)):
    print(ans[i])