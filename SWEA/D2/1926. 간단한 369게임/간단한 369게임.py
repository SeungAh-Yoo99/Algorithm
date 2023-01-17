N = int(input())
 
for i in range(1, N + 1):
    num = str(i) #문자열로 변환
 
    count = 0 #3, 6, 9의 개수
    count = num.count('3') + num.count('6') + num.count('9')
 
    if count > 0:
        print('-' * count, end='') #3, 6, 9 개수만큼 출력
    else:
        print(num, end='')
    
    print(' ', end='')