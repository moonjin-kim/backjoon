import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0,-2,2,0,0]
dy = [0, 0, -1, 1,0,0,-2,2]

M, N = map(int, input().split())

graph = []
visited = [[[0,1] for _ in range(N)] for _ in range(M)]

for _ in range(M):
    graph.append(list(sys.stdin.readline().strip('\n')))

visited[0][0][0] = 1

stack = deque()
stack.append((0,0))
while stack:
    x, y = stack.popleft() 
    n = 1
    if y == M - 1 and x == N -1:
        print(visited[y][x][0] + 1 + visited[y][x][1])
        exit(0)
    for k in range(8):
        if k >= 4:
            n = 0
            if visited[y][x][1] == 0:
             break
        xx = x+dx[k]
        yy = y+dy[k]
        if 0 <= xx and xx < N and 0 <= yy and yy < M:
            if graph[yy][xx] == '0':
                if visited[yy][xx][0] == 0:
                    visited[yy][xx][0] = visited[y][x][0] + 1
                    visited[yy][xx][1] = visited[y][x][1] * n
                    stack.append((xx,yy))
                if visited[yy][xx][1] == 0 and visited[y][x][1] == 1:
                    visited[yy][xx][0] = visited[y][x][0] + 1
                    visited[yy][xx][1] = visited[y][x][1] * n
                    stack.append((xx,yy))
                

print(-1)
    
