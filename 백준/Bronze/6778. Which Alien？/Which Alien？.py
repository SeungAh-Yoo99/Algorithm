# TroyMartian은 적어도 3개의 안테나와 최대 4개의 눈을 가지고 있음.
# VladSaturnian은 최대 6개의 안테나와 적어도 2개의 눈을 가지고 있음.
# GrasmeMercurian은 최대 2개의 안테나와 최대 3개의 눈을 가지고 있음.
# 입력으로 1. 안테나 수, 2. 눈의 수가 주어질 때,
# 해당알 수 있는 외계인명을 출력

antenna = int(input())
eye = int(input())

if antenna >= 3 and eye <= 4:
    print('TroyMartian')

if antenna <= 6 and eye >= 2:
    print('VladSaturnian')

if antenna <= 2 and eye <= 3:
    print('GraemeMercurian')