# UTC+0 기준 시각은 서울보다 9시간이다.
# 한국보다 9시간 느리니까 +9
# +, - 헷갈리지 않기

import datetime

seoul_date = datetime.datetime.now() + datetime.timedelta(hours=9)

print(seoul_date.year)
print(seoul_date.month)
print(seoul_date.day)