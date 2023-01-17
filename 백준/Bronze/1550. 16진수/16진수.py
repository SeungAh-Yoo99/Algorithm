hexa = input()
hexa_list = list(map(str, hexa))
hexa_list.reverse()

deci = 0
for i in range(len(hexa_list)):
    if ord(hexa_list[i]) >= 48 and ord(hexa_list[i]) <= 57: # 0~9라면
        deci += int(hexa_list[i]) * (16 ** i)
    else: # A~F라면
        deci += (ord(hexa_list[i]) - 55) * (16 ** i)

print(deci)