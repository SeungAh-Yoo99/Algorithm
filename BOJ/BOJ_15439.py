# Vera에겐 N개의 상의와 N개의 하의가 있다.
# N개의 상의와 하의는 각각 모두 다른 색이고, 상의와 하의의 색의 구성은 같다.
# 같은 색의 상의와 하의는 입을 수 없을 때, 나올 수 있는 outfit의 개수는?

N = int(input())

print(N * (N -1))