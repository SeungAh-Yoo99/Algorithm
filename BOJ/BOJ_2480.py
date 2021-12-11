dice = list(map(int, input().split()))

# 같은 눈 3개
if dice[0] == dice[1] and dice[1] == dice[2]:
    prize = 10000 + dice[0] * 1000

# 같은 눈 2개(dice[0], dice[1])
elif (dice[0] == dice[1]):
    prize = 1000 + dice[0] * 100

# 같은 눈 2개(dice[0], dice[2])
elif (dice[0] == dice[2]):
    prize = 1000 + dice[0] * 100

# 같은 눈 2개(dice[1], dice[2])
elif (dice[1] == dice[2]):
    prize = 1000 + dice[1] * 100

# 모두 다른 눈
else:
    prize = max(dice) * 100

print(prize)