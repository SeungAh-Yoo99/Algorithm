n = int(input())
p = list(map(int, input().split()))
p.sort() # 오름차순으로 정렬되어 있어야 최소값 가능

sum = 0
result = 0
for i in p:
    sum += i
    result += sum

print(result)