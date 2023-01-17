n = int(input())

# 전봇대 배열
# 배열 인덱스=a 전봇대의 위치
# [i] 번째 배열의 값=a 전봇대의 i번째 전깃줄과 연결된 전깃줄의 b 전봇대에서의 위치
tele_pole = [0 for i in range(500)] 

for i in range(n):
    x, y = map(int, input().split())
    tele_pole[x-1] = y

num = [0 for i in range(500)] # 배열의 오른쪽 중에서 큰 수 중 num이 가장 큰 수의 +1
for i in range(499, -1, -1):
    if (tele_pole[i] != 0):
        for j in range(i+1, 500):
            if (tele_pole[i] < tele_pole[j]) and (num[i] < num[j]+1): # 오른쪽 배열 중 자신보다 큰 수 중 가징 작은 수
                num[i] = num[j] + 1 
                #print(i, j, min, num[i])
        
#print(num)
print(n - (max(num) + 1))