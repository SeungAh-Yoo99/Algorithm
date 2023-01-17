n = int(input())

mem = []

for i in range(n):
    age, name = map(str, input().split())
    age = int(age)
    mem.append((age, name))

sorted_mem = sorted(mem, key=lambda mem: mem[0])

for age, name in sorted_mem:
    print(age, name)