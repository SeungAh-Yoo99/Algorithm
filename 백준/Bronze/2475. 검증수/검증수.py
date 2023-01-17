disting = list(map(int, input().split()))

veri = 0
for i in disting:
    veri += i ** 2

veri = veri % 10
print(veri)