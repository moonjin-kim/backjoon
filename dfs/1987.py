import sys
input = sys.stdin.readline
from collections import defaultdict

r, c = map(int,input().split())

alpabet = []
for _ in range(r):
    alpabet.append(list(input()))

dy = [0,0,1,-1]
dx = [1,-1,0,0]

stack = set()
stack.add(alpabet[0][0])
max_count = 0
def dfs(x,y,count):
    global max_count
    max_count = max(max_count,count)
    stack.add(alpabet[y][x])
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= ny < r and 0 <= nx < c and alpabet[ny][nx] not in stack:
                    dfs(nx,ny,count + 1)
    
    stack.remove(alpabet[y][x])

dfs(0,0,1)
print(max_count)