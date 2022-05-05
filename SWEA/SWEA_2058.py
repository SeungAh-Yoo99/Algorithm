# N = input()
# sum = 0

# for s in N:
#     sum += int(s)

N = int(input())
sum = 0

while(True):
    if (N == 0):
        break
    else:
        sum += N % 10
        N //= 10

print(sum)