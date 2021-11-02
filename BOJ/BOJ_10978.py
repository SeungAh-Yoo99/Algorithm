n = int(input())
list_input = []

for i in range(n):
    list_input.append(int(input()))

dp = []
for i in range(max(list_input) + 1):
    if i == 0 or i == 1 :
        dp.append(0)
    elif i == 2:
        dp.append(1)
    elif i == 3:
        dp.append(2)
    else:
        dp.append((dp[i-2] + dp[i-1]) * (i-1))

for i in range(len(list_input)):
    print(dp[list_input[i]])