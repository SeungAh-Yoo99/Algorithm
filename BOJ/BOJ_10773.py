k = int(input())

arr = []
for i in range(k):
    n = int(input())
    if n == 0: # 0일 경우에만 전에 수를 지워줌.
        arr.pop()
    else:
        arr.append(n)
        
print(sum(arr))


# 맨 처음에 0이 오면 오류가 나서 조건을 붙여줘야 한다고 생각했다.
# 근데 문제에서 틀린 수를 불렀을 때만 0을 말한다고 했으니
# 맨 앞에 0이 올 일은 없다.