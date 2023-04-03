import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split())

graph = []
visited = [[-1 for _ in range(M)] for _ in range(N)]
dx = [0,0,-1,1]
dy = [1,-1,0,0]
for _ in range(N):
    graph.append(list(map(int,input().split())))

que = deque()

for y in range(N):
    for x in range(M):
        if graph[y][x] == 0:
            visited[y][x] = 0
        elif graph[y][x] == 2:
            visited[y][x] = 0
            que.append([x,y])

while que:
    x,y = que.popleft()
    for i in range(4):
        next_x = x + dx[i]
        next_y = y + dy[i]
        if 0 <= next_x < M and 0 <= next_y < N and visited[next_y][next_x] == -1:
            visited[next_y][next_x] = visited[y][x] + 1
            que.append([next_x,next_y])

for i in range(N):
    print(*visited[i])