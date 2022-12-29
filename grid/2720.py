import sys

N= int(input())

answer = []
coins = [25,10,5,1]
for i in range(N):
    a = int(input())
    cnt = [0]*4
    for j in range(len(coins)):
        cnt[j] = a // coins[j]
        a = a % coins[j]
        if a == 0:
            break
    answer.append(cnt)

for i in answer:
    for j in i:
        print(j,end=" ")
    print()