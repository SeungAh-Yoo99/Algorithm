n, m = input().split()
n = int(n)
m = int(m)
c = input().split()

for i in range(0, n):
    c[i] = int(c[i])

max = 0
for i in range(0, n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            sum = c[i] + c[j] + c[k]
            if ((max < sum) & (sum <= m)):
                max = sum

print(max)