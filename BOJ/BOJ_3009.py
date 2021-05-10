x, y = [0, 0, 0], [0, 0, 0]
for i in range(0, 3):
    x[i], y[i] = map(int, input().split())

# x 값 결정
if (x[0] == x[1]): 
    x_4th = x[2]
elif (x[0] == x[2]):
    x_4th = x[1]
else:
    x_4th = x[0]

# y 값 결정
if (y[0] == y[1]): 
    y_4th = y[2]
elif (y[0] == y[2]):
    y_4th = y[1]
else:
    y_4th = y[0]
    
print(x_4th, y_4th)

"""
축에 평행한 직사각형을 만들어야 하기 때문에,
입력 받은 3개의 값 중, x와 y를 따로 보았을 때 각각 같은 값이 2개와 다른 값 1개다.
이때 4번째 x, y는 다른 값과 같은 값을 가져야 축에 평행한 직사각형을 만들 수 있다.
"""