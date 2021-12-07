n = int(input())

dic = {}

for i in range(n):
    age, name = map(str, input().split())
    dic[name] = age
    
# list 타입으로 저장됨
sorted_by_age = sorted(dic.items(), key = lambda item: item[1])    

for key, value in sorted_by_age:
    print(value, key)