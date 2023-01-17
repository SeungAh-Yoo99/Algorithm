# 출력이 x라고 했을 때, x/A를 반올림 한 수가 I이다.
# 그렇다면 실제 I는 I-1.xxxx 이거나 딱 I이거나
# 문제는 적어도 몇 곡인지를 물어봤으므로 A*(I-1)+1 을 구하면 x의 최소값을 구할 수 있다.

A, I = map(int, input().split())

print(A * (I - 1) + 1)