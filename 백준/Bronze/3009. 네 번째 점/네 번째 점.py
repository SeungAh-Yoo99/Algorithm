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