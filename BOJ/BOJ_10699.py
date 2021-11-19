# datetime을 사용하여 출력.
# print 함수의 sep는 각 인자 사이에 붙여줄 문자열을 지정할 수 있음.
# 현재 각 인자 사이에 ' '로 띄어쓰기가 적용되므로 sep=''를 사용하여
# 각 인자 사이에 아무것도 붙여주지 않겠다고 명시.

import datetime

d = datetime.datetime.now()
print(d.year, '-', d.month, '-', d.day, sep='')