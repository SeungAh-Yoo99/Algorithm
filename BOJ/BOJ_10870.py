n = int(input())
pb = [0, 1]

for i in range(2, n+1):
    pb.append(pb[i-1] + pb[i-2])

print(pb[n])