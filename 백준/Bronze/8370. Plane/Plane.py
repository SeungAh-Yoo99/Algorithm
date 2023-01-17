# business class는 n1*k1개의 좌석이 있고,
# economic class는 n2*k2개의 좌석이 있다.
# n1, k1, n2, k2 순으로 입력이 들어올 때,
# 총 좌석의 개수를 출력하라

n1, k1, n2, k2 = map(int, input().split())

print(n1 * k1 + n2 * k2)