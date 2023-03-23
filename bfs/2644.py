import sys
from collections import deque
import math
input = sys.stdin.readline

n = int(input())

degree = [-1 for _ in range(n+1)]
first_degree = [[] for _ in range(n+1)]

target1, target2 = map(int,input().split())

m = int(input())

for _ in range(m):
    start, end = map(int,input().split())
    first_degree[start].append(end)
    first_degree[end].append(start)


def searchGame(N):
    d=deque()
    d.append(N)
    degree[N] = 0
    while d:
        index = d.popleft()
        if index == target2:
            return 0

        for next_index in first_degree[index]:
            if degree[next_index] == -1:
                degree[next_index] = degree[index] + 1
                d.append(next_index)



searchGame(target1)

print(degree[target2])