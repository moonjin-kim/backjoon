import sys

input = sys.stdin.readline
N = int(input())

triple = []

for i in range(N):
    triple.append(list(map(int,input().split())))

k = 2
for i in range(1,N):
    for j in range(len(triple[i])):
        if j == 0:
            triple[i][j] = triple[i][j] + triple[i - 1][j]
        elif i == j:
            triple[i][j] = triple[i][j] + triple[i - 1][j-1]
        else:
            triple[i][j] = max(triple[i-1][j-1],triple[i-1][j]) + triple[i][j]

print(max(triple[N-1]))


