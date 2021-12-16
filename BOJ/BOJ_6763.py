# 첫 번째 줄에 속도 제한을 입력 받고,
# 두 번째 줄에 현재 속도를 입력 받는다.
# 속도 제한에 따른 현재 속도의 상태를 출력한다.

import sys

limit = int(sys.stdin.readline())
speed = int(sys.stdin.readline())

sub = limit - speed

if sub >= 0:
    print('Congratulations, you are within the speed limit!')
elif sub >= -20:
    print('You are speeding and your fine is $100.')
elif sub >= -30:
    print('You are speeding and your fine is $270.')
else:
    print('You are speeding and your fine is $500.')