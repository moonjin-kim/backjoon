import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

M, N, K = map(int, input().split())

tomatos = []

stack = deque()
for k in range(K):
    floor = []
    for i in range(N):
        tomato = list(map(int,input().split()))
        floor.append(tomato)
        for j in range(M):
            if tomato[j] == 1:
                stack.append([j,i, k])
    tomatos.append(floor)

while stack:
    point = stack.popleft()
    x = point[0]
    y = point[1]
    z = point[2]
    for i in range(6):
        if 0 <= x+dx[i] and x+dx[i] < M and 0 <= y+dy[i] and y+dy[i] < N and 0 <= z+dz[i] and z+dz[i] < K:
            if tomatos[z+dz[i]][y+dy[i]][x+dx[i]] == 0:
                tomatos[z+dz[i]][y+dy[i]][x+dx[i]] = tomatos[z][y][x] + 1
                stack.append([x+dx[i],y+dy[i],z+dz[i]])

def days(day):
    for k in range(K):
        for i in range(N):
            for j in range(M):
                if tomatos[k][i][j] == 0:
                    return -1
                
                day = max(day, tomatos[k][i][j])

    return day - 1

print(days(0))



