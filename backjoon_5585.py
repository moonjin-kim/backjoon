import sys

N= int(input())

N = 1000 - N

coins = [500,100,50,10,5,1]
cnt = 0
for i in coins:
    cnt += N // i
    N = N % i
    if N == 0:
        break

print(cnt)